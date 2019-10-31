package com.integrador.persistencia;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.integrador.model.EntidadeBase;

public abstract class GenericoDAO<T extends EntidadeBase> {

	private ConexaoMysql conexao;
	private Field atributos[];
	protected T object;
	private String[] nomeAtributosTabela;
	private Object[] valorAtributosTabela;
	private String nomeTabela;
	private int numeroAtributosTabela;
	private int numeroAtributosClasse;
	private Parser<T> parser;

	public GenericoDAO(T auxiliar) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "BDcasa123", "triband");
		atributos = auxiliar.getClass().getDeclaredFields();

		nomeTabela = auxiliar.getNomeTabela();
		numeroAtributosTabela = auxiliar.getNumeroAtributosTabela();
		numeroAtributosClasse = atributos.length;
		object = auxiliar;
		parser = new Parser<T>(auxiliar);

		valorAtributosTabela = new Object[numeroAtributosClasse];
		nomeAtributosTabela = parser.geraNomeAtributos(atributos, numeroAtributosClasse);

	}

	private PreparedStatement adicionaAtributo(PreparedStatement statement, Object valor, int idx) {

		try {

			statement.setObject(idx, valor);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statement;
	}
	// SALVAR

	public T salvar(T t) {
		this.conexao.abrirConexao();

		String sqlInsertPart1 = "(";
		String sqlInsertPart2 = "(?";

		for (int i = 1; i <= numeroAtributosClasse; i++) {
			if (nomeAtributosTabela[i - 1] == null) {
				valorAtributosTabela[i - 1] = null;
				continue;
			}
			sqlInsertPart1 += nomeAtributosTabela[i - 1];

			// System.out.println(nomeAtributosTabela[i-1]+" ->
			// "+valorAtributosTabela[i-1]);
			// System.out.println(atributos[idx].getName()+" "+atributos[idx].getType());
			valorAtributosTabela[i - 1] = parser.geraObjeto(atributos[i - 1], t);

			if (i < numeroAtributosTabela)
				sqlInsertPart1 += ",";

			if (i > 1)
				sqlInsertPart2 += ",?";
		}
		// adiciona os "?" na query de acordo com o numero de atributos

		String sqlInsert = "INSERT INTO " + nomeTabela + sqlInsertPart1 + ") VALUES" + sqlInsertPart2 + ");";

		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);

			for (int i = 1; i <= numeroAtributosClasse; i++) {
				if (nomeAtributosTabela[i - 1] == null)
					continue;

				statement = adicionaAtributo(statement, valorAtributosTabela[i - 1], i);

			}
			System.out.println(sqlInsert);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();

			if (rs.next())
				t.setId(rs.getLong(1));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();

		}
		return t;
	}

	public boolean deletar(long id) {
		this.conexao.abrirConexao();
		boolean resposta = false;

		String sqlDelete = "DELETE FROM " + nomeTabela + " WHERE id_" + nomeTabela + "=?;";

		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);

			statement.setLong(1, id);

			resposta = (statement.executeUpdate() > 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

		return resposta;
	}

	public T editar(T novo) {
		this.conexao.abrirConexao();
		String sqlUpdate1 = "UPDATE " + novo.getNomeTabela() + " SET ";
		String sqlUpdate2 = " WHERE id_" + novo.getNomeTabela() + "=?";
		boolean virgula = false;

		int idChavePrimaria = 0;

		for (int i = 0; i < numeroAtributosClasse; i++) {
			if (nomeAtributosTabela[i] == null) {
				valorAtributosTabela[i] = null;
				continue;
			}
			valorAtributosTabela[i] = parser.geraObjeto(atributos[i], novo);
			if (nomeAtributosTabela[i].equals("id_" + novo.getNomeTabela())) {
				idChavePrimaria = i;
				continue;
			}

			if (virgula)
				sqlUpdate1 += ", ";

			sqlUpdate1 += nomeAtributosTabela[i];
			sqlUpdate1 += "=?";

			virgula = true;
		}
		sqlUpdate2 += " ;";
		String sqlUpdate = sqlUpdate1 + sqlUpdate2;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);

			int idx = 1;
			for (int i = 0; i < numeroAtributosClasse; i++) {
				if (nomeAtributosTabela[i] == null)
					continue;
				int id = idx;
				if (i == idChavePrimaria) {
					id = numeroAtributosTabela;
					idx--;
				}
				statement = adicionaAtributo(statement, valorAtributosTabela[i], id);
				idx++;
			}

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

		return novo;
	}

	protected List<T> busca(String query, Object valorEspecifico[]) {
		this.conexao.abrirConexao();

		ArrayList<T> resultado = new ArrayList<T>();

		try {
			String sqlSelect = "SELECT * FROM " + nomeTabela + " " + parser.geraInnerJoin(object) + " " + query + ";";

			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlSelect);
			if (query.length() > 0) {
				int tam = valorEspecifico.length;
				for (int i = 0; i < tam; i++)
					statement = adicionaAtributo(statement, valorEspecifico[i], i + 1);
			}

			ResultSet rs = statement.executeQuery();

			Constructor<T> construtor = (Constructor<T>) object.getClass().getConstructor(null);

			while (rs.next()) { // (51) 991236693

				T novo = construtor.newInstance();

				for (int idx = 0; idx < numeroAtributosClasse; idx++) {

					if (nomeAtributosTabela[idx] == null)
						continue; // Passa pelos atributos da classe que não estão na tabela

					Object valor = rs.getObject(nomeAtributosTabela[idx]);

					if (parser.ehChaveEstrangeira(atributos[idx])) {

						Class<?> tipoFilho = atributos[idx].getType();
						Constructor<EntidadeBase> construtorFilho = (Constructor<EntidadeBase>) tipoFilho
								.getConstructor(null);

						Object filho = construtorFilho.newInstance();

						Field[] atributosFilho = tipoFilho.getDeclaredFields();
						EntidadeBase filhoAux = (EntidadeBase) tipoFilho.getConstructor(null).newInstance(null);
						int tamanhoClasseFilho = atributosFilho.length;
						String[] nomesAtributosFilho = parser.geraNomeAtributos(atributosFilho, tamanhoClasseFilho);

						for (int i = 0; i < tamanhoClasseFilho; i++) {
							if (nomesAtributosFilho[i] == null)
								continue;
							Object valorAtriFilho = rs.getObject(nomesAtributosFilho[i]);
							if (parser.ehChaveEstrangeira(atributosFilho[i])) {
								EntidadeBase objAtriFilho = (EntidadeBase) atributosFilho[i].getType()
										.getConstructor(null).newInstance();
								objAtriFilho.setId((Long) valorAtriFilho);
								valorAtriFilho = objAtriFilho;
							}
							atributosFilho[i].set(filho, valorAtriFilho);
						}

						valor = filho;
					}

					atributos[idx].set(novo, valor);

				}
				resultado.add(novo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

		return resultado;
	}

	protected T buscaUm(String field, Object valor) {
		List<T> ans = buscaPorAtributo(field, valor);
		if (ans.size() == 1)
			return ans.get(0);
		return null;
	}

	public T buscarPorId(Long id) {
		String nome = object.getClass().getSimpleName();
		return buscaUm("id"+nome, id);
	}

	public List<T> buscarTodos() {
		return busca("", null);
	}

	protected List<T> buscaPorAtributo(String field, Object valor) {
		try {
			Field atributo = parser.geraAtributo(field);
			Field atributosValor[] = atributo.getType().getDeclaredFields();
			int tam = atributosValor.length;
			
			String nomeAtributos[] = parser.geraNomeAtributos(atributosValor, tam);

			Object valores[] = new Object[tam];
			for (int i = 0; i < tam; i++) {
				if(nomeAtributos[i]==null) continue;
				if(parser.ehChaveEstrangeira(atributosValor[i])) {
					nomeAtributos[i]=null;
					continue;
				}
				Object valorAtributo = atributosValor[i].get(valor);
				if(valorAtributo==null) {
					nomeAtributos[i]=null;
					continue;
				}
				
				valores[i] = valorAtributo;
			}

			String query = geraQuery(atributo, atributosValor,nomeAtributos);
			return busca(query, valores);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private String geraQuery(Field field, Field[] atributosField,String nomeAtributos[]) {
		int tamanho = atributosField.length;

		String sqlQuery = " WHERE ";
		String nome = nomeTabela;
		boolean and = false;
		for (int i = 0; i < tamanho; i++) {
			if (nomeAtributos[i] == null)
				continue;
			if (and)
				sqlQuery += " AND ";
			sqlQuery += nome + "." + nomeAtributos[i] + "=? ";
			and = true;
		}
		return sqlQuery;
	}

}
