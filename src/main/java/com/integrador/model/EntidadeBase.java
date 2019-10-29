package com.integrador.model;

public abstract class EntidadeBase {
	protected String nomeTabela;
	protected int numeroAtributosTabela;

	public String getNomeTabela() {
		return nomeTabela;
	}

	public int getNumeroAtributosTabela() {
		return numeroAtributosTabela;
	}

	public abstract Long getId();

	public abstract void setId(Long id);
}
