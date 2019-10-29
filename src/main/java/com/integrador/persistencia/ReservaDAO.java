package com.integrador.persistencia;

import java.sql.Time;
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
		// TODO Auto-generated method stub
		return null;
	}

}
