package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.integrador.model.Reserva;

public class ReservaDAO extends GenericoDAO<Reserva>{

	public ReservaDAO(Reserva auxiliar) {
		super(auxiliar);
		// TODO Auto-generated constructor stub
	}

	public List<Reserva> buscarPorHorario(Time inicio, Time fim) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> buscarPorPreco(Double preco) {
		super.conexao.abrirConexao();
		List<Reserva> reservas = new ArrayList<>();
		
		String sqlBuscar = "SELECT * FROM reserva INNER JOIN banda ON reserva.id_banda = banda.id_banda INNER JOIN agenda ON agenda.id_agenda = reserva.id_reserva WHERE reserva.preco <= ?";
		PreparedStatement statement;
		
		try {
			statement = super.conexao.getConexao().prepareStatement(sqlBuscar);
			statement.setDouble(1, preco);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){ 
				Reserva r = new Reserva();
				r.getAgenda().setId(rs.getLong("id_agenda"));
				
				
				//terminar
				
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
