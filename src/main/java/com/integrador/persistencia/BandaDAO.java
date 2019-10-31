package com.integrador.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.integrador.model.Banda;

public class BandaDAO extends GenericoDAO<Banda>{

	public BandaDAO(Banda auxiliar) {
		super(auxiliar);
		// TODO Auto-generated constructor stub
	}

	public Banda buscarPorEmail(String email) {
		return buscaUm("email",email);
	}

	
	
}
