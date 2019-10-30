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
	private String[] nomeAtributosTabela;
	private Object[] valorAtributosTabela;
	private String nomeTabela;
	private int numeroAtributosTabela;
	private int numeroAtributosClasse;
	private Parser parser;
	public GenericoDAO(T auxiliar) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "BDcasa123", "triband");
		atributos = auxiliar.getClass().getDeclaredFields();

		nomeTabela = auxiliar.getNomeTabela();
		numeroAtributosTabela = auxiliar.getNumeroAtributosTabela();
		numeroAtributosClasse = atributos.length;
		object = auxiliar;
		parser = new Parser();

		nomeAtributosTabela = new String[numeroAtributosTabela];
		valorAtributosTabela = new Object[numeroAtributosTabela];
		int idx = 0;
		for(int i=0;i<numeroAtributosClasse;i++) {
			atributos[i].setAccessible(true);       // necessario para podermos pegar o valor do atributo
			String ans = parser.geraNome(atributos[i]);
			if(ans!=null) nomeAtributosTabela[idx++] = ans;
			else atributos[i] = null;
		}

	
	}

	private PreparedStatement adicionaAtributo(PreparedStatement statement, T t, int idx) {

		try {
			Object valor = valorAtributosTabela[idx-1]; // pega o valor do atributo no objeto t
			
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
		int idx = 0;
		for(int i=1;i<=numeroAtributosTabela;i++) {
			
			while(atributos[idx]==null) idx++;
			
			sqlInsertPart1+=nomeAtributosTabela[i-1];
			
			valorAtributosTabela[i-1] = parser.geraObjeto(atributos[idx++], t);
			
			
			System.out.println(nomeAtributosTabela[i-1]+" -> "+valorAtributosTabela[i-1]);
			if(i<numeroAtributosTabela) sqlInsertPart1+=","; 
				
			if(i>1) sqlInsertPart2+=",?";
		}
		// adiciona os "?" na query de acordo com o numero de atributos
		
		String sqlInsert ="INSERT INTO "+nomeTabela +sqlInsertPart1 +") VALUES"+ sqlInsertPart2+");";
		
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
		

			for (int i = 1; i <= numeroAtributosTabela; i++) {
				
				statement = adicionaAtributo(statement, t, i);

			}
			System.out.println(sqlInsert);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			
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
	public T editar( T novo) {
		this.conexao.abrirConexao();
		String sqlUpdate = "REPLACE "+nomeTabela+" VALUE(?";
		for(int i=1;i<numeroAtributosTabela;i++) {
			sqlUpdate+=",?";
		}
		sqlUpdate+=");";
		
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
		
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
	
	public T buscarPorId(Long id) {
	return null;		
	}
	
	public List<T> buscarTodos(){
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
