package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;

public class EstudioDAO extends GenericoDAO<Estudio>{

	public EstudioDAO(Estudio auxiliar) {
		super(auxiliar);
		// TODO Auto-generated constructor stub
	}

	public Estudio buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		super.conexao.abrirConexao();
		Estudio estudio = null;
		
		String sqlBuscar = "";
		PreparedStatement statement;
		
		 try {
			statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscar);
			statement.setString(1,email);
			ResultSet rs=statement.executeQuery();
			
			 if(rs.next()){
				 
		            estudio = new Estudio();
		            estudio.setId(rs.getLong("id_banda"));
		            estudio.setNome(rs.getString("nome"));
		            estudio.setSenha(rs.getString("senha"));
		            estudio.setEmail(rs.getString("email"));
		            estudio.setCnpj(rs.getString("cnpj"));
		            
		            //agenda do estudio
		          
		            
		            
		            //localizacao do estudio
		            
		            estudio.getLocalizacao().setId(rs.getLong("id_localizacao"));
		            estudio.getLocalizacao().setBairro(rs.getString("bairro"));
		            estudio.getLocalizacao().setCep(rs.getLong("cep"));
		            estudio.getLocalizacao().setCidade(rs.getString("cidade"));
		            estudio.getLocalizacao().setEstado(rs.getString("estado"));
		            estudio.getLocalizacao().setLatitude(rs.getDouble("latitude"));
		            estudio.getLocalizacao().setLongitude(rs.getDouble("longitude"));
		            estudio.getLocalizacao().setNumero(rs.getInt("numero"));
		            estudio.getLocalizacao().setRua(rs.getString("rua"));
		        }

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	   		 this.conexao.fecharConexao();
	   	 }

		return estudio;
	}

}
