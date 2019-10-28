package com.integrador.model;

public interface EntidadeBase {

	public Long getId();
	public void setId(Long id);
	
	public String getNomeTabela();
	public int getNumeroAtributosTabela();
}
