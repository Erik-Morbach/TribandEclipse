package com.integrador.persistencia;

import java.util.List;

import com.integrador.model.Banda;

public class BandaDAO extends GenericoDAO<Banda>{

	public BandaDAO() {
		super(new Banda());
		// TODO Auto-generated constructor stub
	}

	public Banda buscarPorEmail(String email) {
		return buscaUm("email",email);
	}
	public List<Banda> buscaPorNome(String nome){
		return buscaPorAtributo("nome",nome);
	}

	
	
}
