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
		return buscaUm("email",email);
	}

}
