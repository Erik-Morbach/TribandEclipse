package com.integrador.persistencia;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Pair;

import com.integrador.model.Estudio;
import com.integrador.model.Localizacao;

public class EstudioDAO extends GenericoDAO<Estudio> {

	public EstudioDAO() {
		super(new Estudio());
		// TODO Auto-generated constructor stub
	}
	public Estudio buscarPorEmail(String email) {
		return buscaUm("email",email);
	}
	public List<Estudio> buscarPorProximidade(Double latitude,Double longitude,Double raio){
		return busca("WHERE distanciaEntrePontos(?,?,localizacao.latitude,localizacao.longitude)<=? ", new Object[] {latitude,longitude,raio});
	}
	public List<Estudio> buscaPorLocalizacao(Localizacao localizacao){
		return buscaPorAtributo("localizacao",localizacao);
	}
	public List<Estudio> buscaPorPreco(Double preco){
		return busca("WHERE estudio.preco<=?",preco);
	}
	public List<Estudio> buscaPorHorarioDisponivel(Time inicio, Time fim){
		return null;
	}
	public List<Estudio> buscaPorProximidadeLocalizacaoPrecoHorarioDisponivel(Double latitude,Double longitude,Double raio,Localizacao localizacao,Double preco,Time inicio,Time fim){
		
		String queryProximidade = "distanciaEntrePontos(?,?,localizacao.latitude,localizacao.longitude)<=?";
		ArrayList<Object> valorProximidade = new ArrayList<Object>();
		valorProximidade.add(latitude); valorProximidade.add(longitude); valorProximidade.add(raio);
		
		Pair<String,List<Object>> queryLocalizacaoPair =  geraQuery("localizacao",localizacao,"",null);
		String queryLocalizacao = queryLocalizacaoPair.getFirst();
		ArrayList<Object> valorLocalizacao = (ArrayList<Object>) queryLocalizacaoPair.getSecond();
		String queryPreco = "estudio.preco<=?";
		ArrayList<Object> valorPreco = new ArrayList<Object>();
		valorPreco.add(preco);
		String queryHorarioDisponivel="";
		ArrayList<Object> valorHorarioDisponivel = new ArrayList<Object>();
		valorHorarioDisponivel.add(inicio);valorHorarioDisponivel.add(fim);
		
		String querys[] = {queryProximidade,queryLocalizacao,queryPreco,queryHorarioDisponivel};
		ArrayList<ArrayList<Object>> valorQuerys = new ArrayList<ArrayList<Object>>(); 
		// java não possui arrayList<Object> [], então temos que usar um
		//ArrayList<ArrayList<Object>>
		valorQuerys.add(valorProximidade); valorQuerys.add(valorLocalizacao);
		valorQuerys.add(valorPreco); valorQuerys.add(valorHorarioDisponivel);
		
		String query = " WHERE";
		ArrayList<Object> valores = new ArrayList<Object>();
		int foi = 0;
		for(int i=0;i<querys.length;i++) {

			int tenta = 0;
			for(int j=0;j<valorQuerys.get(i).size();j++) {
				if(valorQuerys.get(i).get(j)==null) tenta++;
			}
			
			if(tenta==valorQuerys.get(i).size()) continue;
			
			foi++;
			query+= " "+querys[i];
			valores.add(valorQuerys.get(i));
		}
		if(foi==0) query = "";
		
		return busca(query,valores);
	}
	
	
	
}
