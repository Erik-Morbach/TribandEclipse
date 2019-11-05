package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;
import com.integrador.model.Reserva;

public class ReservaDAO extends GenericoDAO<Reserva>{

	public ReservaDAO() {
		super(new Reserva());
		// TODO Auto-generated constructor stub
	}

	public List<Reserva> buscaPorBanda(Banda banda){
		return buscaPorAtributo("banda",banda);
	}
	
	public List<Reserva> buscaPorEstudio(Estudio estudio){
		return buscaPorAtributo("estudio",estudio);
	}


}
