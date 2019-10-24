package com.integrador.persistencia;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.integrador.model.EntidadeBase;

public class GenericoDAO<T extends EntidadeBase> {

	private ConexaoMysql conexao;

	public GenericoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "3030", "root", "dudu142414", "Triband");
	}

	private PreparedStatement adicionaAtributo(PreparedStatement statement, Field atributo, T t, int idx) {
		String nome = atributo.getName();
		atributo.setAccessible(true);
		Object valor = null;
		try {
			valor = t.getClass().getField(nome);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		try {
			if (valor instanceof Long) {
				statement.setLong(idx, (Long) valor);
			} else if (valor instanceof Integer) {
				statement.setInt(idx, (Integer) valor);
			} else if (valor instanceof Time) {
				statement.setTime(idx, (Time) valor);
			} else if (valor instanceof Double) {
				statement.setDouble(idx, (Double) valor);
			} else if (valor instanceof String) {
				statement.setString(idx, (String) valor);
			} else if (valor instanceof Date) {
				statement.setDate(idx, (Date) valor);
			} else if (valor.getClass().isArray())
				return statement;
			else {
				statement.setLong(idx, ((EntidadeBase) valor).getId());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statement;
	}
	// SALVAR

	public T Salvar(T t) {
		this.conexao.abrirConexao();

		String nomeClasse = t.getNomeTabela();
		
		String sqlInsert = "INSERT INTO " + nomeClasse + " VALUES(null";

		Field[] atributos = t.getClass().getFields();

		int qntAtributos = atributos.length;
		// adiciona os "?" na query de acordo com o numero de atributos
		for (int i = 1; i < qntAtributos; i++)
			sqlInsert += ",?";

		sqlInsert += ");";

		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// o primeiro atributo é o id e o ultimo é o nome da tabela,
			// estes não devem ser setados no statement
			for (int i = 2; i < qntAtributos; i++) {
				Field w = atributos[i];

				statement = adicionaAtributo(statement, w, t, i);
			}
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();

		}
		return t;
	}

	
	
	
}
