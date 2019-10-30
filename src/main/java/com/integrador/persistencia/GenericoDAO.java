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

	protected ConexaoMysql conexao;
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
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "ifsul2017", "triband");
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
		int idx = 0;
		for(int i=1;i<=numeroAtributosTabela;i++) {
			
			while(atributos[idx]==null) idx++;
			
			sqlInsertPart1+=nomeAtributosTabela[i-1];

			//System.out.println(nomeAtributosTabela[i-1]+" -> "+valorAtributosTabela[i-1]);
		//	System.out.println(atributos[idx].getName()+"  "+atributos[idx].getType());
			valorAtributosTabela[i-1] = parser.geraObjeto(atributos[idx++], t);
			
			
			if(i<numeroAtributosTabela) sqlInsertPart1+=","; 
				
			if(i>1) sqlInsertPart2+=",?";
		}
		// adiciona os "?" na query de acordo com o numero de atributos
		
		String sqlInsert ="INSERT INTO "+nomeTabela +sqlInsertPart1 +") VALUES"+ sqlInsertPart2+");";
		
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
		

			for (int i = 1; i <= numeroAtributosTabela; i++) {
				
				statement = adicionaAtributo(statement, valorAtributosTabela[i-1], i);

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
		String sqlUpdate1 = "UPDATE "+novo.getNomeTabela() + " SET ";
		String sqlUpdate2 = " WHERE id_"+novo.getNomeTabela()+"=?";
		boolean virgula = false;
		
		int idChavePrimaria = 0;
		
		
		
		for(int i=0;i<numeroAtributosTabela;i++) {
			valorAtributosTabela[i] = parser.geraObjeto(atributos[i], novo);
			if(nomeAtributosTabela[i].equals("id_"+novo.getNomeTabela())) {
				idChavePrimaria = i;
				continue;
			}

			if(virgula) sqlUpdate1+=", ";
			
			sqlUpdate1+= nomeAtributosTabela[i];
			sqlUpdate1+="=?";
			
			virgula = true;
		}
		sqlUpdate2+=" ;";
		String sqlUpdate = sqlUpdate1 + sqlUpdate2;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			System.out.println(sqlUpdate);
			int idx = 1;
			for(int i=0;i<numeroAtributosTabela;i++) {
				int id = idx;
				if(i==idChavePrimaria) {
					id = numeroAtributosTabela;				
					idx--;
				}
				System.out.println(valorAtributosTabela[i]+" -> "+id);
				statement = adicionaAtributo(statement, valorAtributosTabela[i], id);
				idx++;
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
