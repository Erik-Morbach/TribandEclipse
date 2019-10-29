package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.Banda;

public class BandaDAO extends GenericoDAO<Banda>{

	public BandaDAO(Banda auxiliar) {
		super(auxiliar);
		// TODO Auto-generated constructor stub
	}

	public Banda buscarPorEmail(String email) {
		super.conexao.abrirConexao();
		Banda banda = null;
		
		String sqlBuscar = "SELECT * FROM banda INNER JOIN agenda ON agenda.id_banda = banda.id_banda WHERE banda.email=?;";
		PreparedStatement statement;
		
		 try {
			statement = (PreparedStatement) super.conexao.getConexao().prepareStatement(sqlBuscar);
			statement.setString(1,email);
			ResultSet rs=statement.executeQuery();
			
			 if(rs.next()){
		            banda = new Banda();
		            banda.setId(rs.getLong("id_banda"));
		            banda.setNome(rs.getString("nome"));
		            banda.setSenha(rs.getString("senha"));
		            banda.setEmail(rs.getString("email"));
		            banda.setIntegrantes(rs.getInt("integrantes"));
		            
		            //agenda da banda
		            
		            banda.getAgenda().setId(rs.getLong("id_agenda"));
		            banda.getAgenda().setBanda(banda);
		        }

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	   		 this.conexao.fecharConexao();
	   	 }

		return banda;
	}

	
	
}
