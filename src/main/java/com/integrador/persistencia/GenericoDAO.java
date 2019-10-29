package com.integrador.persistencia;

import java.lang.reflect.Field;
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
	private T object;
	private String nomeTabela;
	private int numeroAtributosTabela;
	private int numeroAtributosClasse;
	private int indiceQuery;
	
	public GenericoDAO(T auxiliar) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "BDcasa123", "triband");
		atributos = auxiliar.getClass().getDeclaredFields();
		Arrays.sort(atributos, new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});

		nomeTabela = auxiliar.getNomeTabela();
		numeroAtributosTabela = auxiliar.getNumeroAtributosTabela();
		numeroAtributosClasse = atributos.length;
		object = auxiliar;
	}

	private PreparedStatement adicionaAtributo(PreparedStatement statement, T t, int idx) {

		atributos[idx-1].setAccessible(true); // necessario para podermos pegar o valor do atributo
		
		// se o atributo for uma lista ele não deve ser tratado;
		
		
		
		try {
			Object valor = atributos[idx-1].get(t); // pega o valor do atributo no objeto t

			// verifica se o atributo é na verdade uma chave estrangeira
			if (valor != null) {
				if (valor instanceof EntidadeBase)
					valor = ((EntidadeBase) valor).getId();
				if(valor instanceof List)
					return statement;
			}
			// se ele herda da Entidade Base, obviamente é um model
			// sendo um model ele deve ser tratado como uma chave estrangeira

			statement.setObject(indiceQuery, valor);
			indiceQuery++;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
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

		String sqlInsert = "INSERT INTO " + nomeTabela + " VALUES(?";

		// adiciona os "?" na query de acordo com o numero de atributos
		for (int i = 1; i < numeroAtributosTabela; i++)
			sqlInsert += ",?";

		sqlInsert += ");";

		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			indiceQuery = 1;

			for (int i = 0; i < numeroAtributosClasse; i++) {

				statement = adicionaAtributo(statement, t, i+1);

			}

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			int id = 1;
			
			if(rs.next()) 
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
		boolean resposta=false;
		
		String sqlDelete = "DELETE FROM " + nomeTabela + " WHERE id_" + nomeTabela + "=?;";
		
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);

			statement.setLong(1, id);

			resposta = (statement.executeUpdate()>0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}

		return resposta;
	}
	public T edita( T novo) {
		this.conexao.abrirConexao();
		String sqlUpdate = "REPLACE "+nomeTabela+" VALUE(?";
		for(int i=1;i<numeroAtributosTabela;i++) {
			sqlUpdate+=",?";
		}
		sqlUpdate+=");";
		
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			indiceQuery = 1;
			for(int i=0;i<numeroAtributosClasse;i++) {
				adicionaAtributo(statement, novo, i+1);
			}
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
		
		return novo;
	}
	
	public List<T> buscaTodos(){
		this.conexao.abrirConexao();
		
		ArrayList<T> resultado = new ArrayList<T>();
		
		String sqlSelect = "SELECT * FROM "+nomeTabela+";";
		
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlSelect);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				T novo = (T) new Object();

				

				for(int idx=1;idx<=numeroAtributosTabela;idx++) {
					//atributos[idx].set(novo, rs.getObject(idx);
					rs.getObject(idx);
					
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		
		
		return resultado;
	}
	
	
}
