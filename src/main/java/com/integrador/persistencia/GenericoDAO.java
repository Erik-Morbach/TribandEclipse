package com.integrador.persistencia;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.EntidadeBase;

public class GenericoDAO<T extends EntidadeBase> {

	private ConexaoMysql conexao;

	public GenericoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "BDcasa123", "triband");
	}

	private PreparedStatement adicionaAtributo(PreparedStatement statement, Field atributo, T t, int idx) {

		atributo.setAccessible(true); // necessario para podermos pegar o valor do atributo

		Object valor = null;
		try {
			valor = atributo.get(t); // pega o valor do atributo no objeto t
			
			// verifica se o atributo é na verdade uma chave estrangeira
			if(valor!=null) 
				if(valor instanceof EntidadeBase)  		
					valor = ((EntidadeBase) valor).getId();
			//	se ele herda da Entidade Base, obviamente é um model
			//	sendo um model ele deve ser tratado como uma chave estrangeira
			
			statement.setObject(idx, valor);

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

	public T Salvar(T t) {
		this.conexao.abrirConexao();

		String nomeTabela = t.getNomeTabela();

		String sqlInsert = "INSERT INTO " + nomeTabela + " VALUES(null";

		Field[] atributos = t.getClass().getDeclaredFields();
		// classe feita com a seguinte organização
		// classe{
		// ->atributos da tabela
		//
		// ->vetores
		//
		// ->nome da tabela


		int qntAtributos = t.getNumeroAtributosTabela();

		// adiciona os "?" na query de acordo com o numero de atributos
		for (int i = 1; i < qntAtributos; i++) 
			sqlInsert += ",?";	

		sqlInsert += ");";

		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);

			for (int i = 1; i < qntAtributos; i++) {
				Field w = atributos[i];

				statement = adicionaAtributo(statement, w, t, i);
			}

			statement.execute();
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

}
