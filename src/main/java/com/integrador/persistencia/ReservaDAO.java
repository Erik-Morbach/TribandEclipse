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



}
