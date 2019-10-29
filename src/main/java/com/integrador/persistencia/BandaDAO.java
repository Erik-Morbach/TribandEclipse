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
		
		String sqlBuscar = "SELECT banda b INNER JOIN agenda a ON b.id_banda=a.id_banda "
			                         	+ "INNER JOIN foto f ON b.id_foto=f.id_foto"
			                         	+ "INNER JOIN  WHERE email=?;";
		PreparedStatement statement;
		
		 try {
			statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscar);
			statement.setString(1,email);
			ResultSet rs=statement.executeQuery();
			
			 if(rs.next()){
		            banda = new Banda();
		            banda.setId(rs.getLong("id_banda"));
		            banda.setNome(rs.getString("nome"));
		            
		            
		            
		            
		            banda.getAgenda().setId(rs.getLong("id_agenda"));
		        }

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return null;
	}

	
	
}
