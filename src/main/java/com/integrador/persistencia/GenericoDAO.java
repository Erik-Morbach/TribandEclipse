package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.integrador.model.EntidadeBase;

public class GenericoDAO< T extends EntidadeBase > {

	private ConexaoMysql conexao;
	
	public GenericoDAO(){
		super();
		this.conexao = new ConexaoMysql("localhost","3030","root","dudu142414","Triband");
	}
	
	//SALVAR 
	
	public T Salvar(T t){
		this.conexao.abrirConexao();
	   	 String sqlInsert = "INSERT INTO usuario VALUES(null,?,?,?)";
	   	 try {
	   		 PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
	   	
		
		return t;
	   	 }catch (SQLException e) {
	   		 e.printStackTrace();
	   	 } finally {
	   		 this.conexao.fecharConexao();
	   	 }
	   	 return t;
	    }


	
	}
	

