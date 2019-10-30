package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Localizacao;

public class LocalizacaoDAO extends GenericoDAO<Localizacao>{

	public LocalizacaoDAO(Localizacao auxiliar) {
		super(auxiliar);
		// TODO Auto-generated constructor stub
	}

	public List<Localizacao> buscarPorProximidade(Localizacao localizacao) {
		// TODO Auto-generated method stub
		super.conexao.abrirConexao();
		List<Localizacao> lista = new ArrayList<>();
		String sql = "SELECT * FROM localizacao AS l WHERE l.estado=?";
		PreparedStatement statement;
		
		try {
			statement = (PreparedStatement) super.conexao.getConexao().prepareStatement(sql);
			statement.setString(1,localizacao.getEstado());
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				Localizacao l = new Localizacao();
				l.setBairro(rs.getString("bairro"));
				l.setCep(rs.getLong("cep"));
				l.setCidade(rs.getString("cidade"));
				l.setEstado(rs.getString("estado"));
				l.setId(rs.getLong("id_localizacao"));
				l.setLatitude(rs.getDouble("latitude"));
				l.setLongitude(rs.getDouble("longitude"));
				l.setNumero(rs.getInt("numero"));
				l.setRua(rs.getString("rua"));
			
				lista.add(l);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.conexao.fecharConexao();
		}
		
		
		return lista;
	}

}
