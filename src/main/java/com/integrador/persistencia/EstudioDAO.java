package com.integrador.persistencia;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.data.util.Pair;

import com.integrador.model.Estudio;
import com.integrador.model.Localizacao;

public class EstudioDAO extends GenericoDAO<Estudio> {
	public static final int ORDENAPORPRECO = 1;
	public static final int ORDENAPORPROXIMIDADE = 2;

	public EstudioDAO() {
		super(new Estudio());
		// TODO Auto-generated constructor stub
	}

	public Estudio buscarPorEmail(String email) {
		return buscaUm("email", email);
	}

	public List<Estudio> buscarPorProximidade(Double latitude, Double longitude, Double raio) {
		return busca(
				"WHERE distancia(?,?,localizacao.latitude,localizacao.longitude)<=? ORDER BY distancia(?,?,localizacao.latitude,localizacao.longitude)",
				new Object[] { latitude, longitude, raio, latitude, longitude });
	}

	public List<Estudio> buscaPorLocalizacao(Localizacao localizacao) {
		return buscaPorAtributo("localizacao", localizacao);
	}

	public List<Estudio> buscaPorPreco(Double preco) {
		return busca("WHERE estudio.preco<=?", preco);
	}

	public List<Estudio> buscaPorHorarioDisponivel(Time inicio, Time fim) {
		return null;
	}

	public List<Estudio> buscaPorProximidadeLocalizacaoPrecoHorarioDisponivel(Double latitude, Double longitude,
			Double raio, Localizacao localizacao, Double preco, Time inicio, Time fim, int ordenacao) {

		String queryProximidade = "distancia(?,?,localizacao.latitude,localizacao.longitude)<=?";
		ArrayList<Object> valorProximidade = new ArrayList<Object>();
		valorProximidade.add(latitude);
		valorProximidade.add(longitude);
		valorProximidade.add(raio);

		Pair<String, List<Object>> queryLocalizacaoPair = 
				(localizacao != null
				?
				geraQuery("localizacao", localizacao, "", null)
				: 
				Pair.of("", new ArrayList<Object>()));

		String queryLocalizacao = queryLocalizacaoPair.getFirst();
		ArrayList<Object> valorLocalizacao = (ArrayList<Object>) queryLocalizacaoPair.getSecond();
		String queryPreco = "estudio.preco<=?";
		ArrayList<Object> valorPreco = new ArrayList<Object>();
		valorPreco.add(preco);
		String queryHorarioDisponivel = "";
		ArrayList<Object> valorHorarioDisponivel = new ArrayList<Object>();
		valorHorarioDisponivel.add(inicio);
		valorHorarioDisponivel.add(fim);

		String querys[] = { queryProximidade, queryLocalizacao, queryPreco, queryHorarioDisponivel };
		ArrayList<ArrayList<Object>> valorQuerys = new ArrayList<ArrayList<Object>>();
		// java não possui arrayList<Object> [], então temos que usar um
		// ArrayList<ArrayList<Object>>
		valorQuerys.add(valorProximidade);
		valorQuerys.add(valorLocalizacao);
		valorQuerys.add(valorPreco);
		valorQuerys.add(valorHorarioDisponivel);

		String query = "";
		String ordena = "";
		ArrayList<Object> valores = new ArrayList<Object>();

		for (int i = 0; i < querys.length; i++) {

			int tenta = 0;
			for (int j = 0; j < valorQuerys.get(i).size(); j++) {
				if (valorQuerys.get(i).get(j) == null)
					tenta++;
			}

			if (tenta == valorQuerys.get(i).size())
				continue; // se todos os valores da query forem nulos você pula pra proxima;

			query += " " + querys[i];

			valorQuerys.get(i).forEach(new Consumer<Object>() {
				public void accept(Object t) {
					valores.add(t);
				}
			});

		}
		if (!query.isEmpty())
			query = " WHERE ".concat(query);

		Pair<String, List<Object>> ordenacaoPair = geraOrdenacao(ordenacao, latitude, longitude);
		ordena = ordenacaoPair.getFirst();
		
		ordenacaoPair.getSecond().forEach(new Consumer<Object>() {
			public void accept(Object t) {
				valores.add(t);
			}
		});
		query += ordena;

		return busca(query, valores.toArray());
	}

	private Pair<String, List<Object>> geraOrdenacao(int ordenacao, double latitude, double longitude) {
		String ordena = "";
		ArrayList<Object> valores = new ArrayList<Object>();
		switch (ordenacao) {
		case ORDENAPORPRECO:
			ordena += "estudio.preco";
			break;
		case ORDENAPORPROXIMIDADE:
			ordena += "distancia(?,?,localizacao.latitude,localizacao.longitude)";
			valores.add(latitude);
			valores.add(longitude);
			break;
		default:
			break;
		}
		if (!ordena.isEmpty())
			ordena = " ORDER BY ".concat(ordena);
		return Pair.of(ordena, valores);
	}
}
