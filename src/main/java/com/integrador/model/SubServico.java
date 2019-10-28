package com.integrador.model;

public class SubServico implements EntidadeBase {
	
	private Long idSubServico;
	private String descricao;
	private Servico servico;
	private final String nomeTabela = "subservico";
	private final int numeroAtributosTabela=3;
	
	public SubServico(){ super(); }
	public SubServico(Long idSubServico, String descricao, Servico servico) {
		super();
		this.idSubServico = idSubServico;
		this.descricao = descricao;
		this.servico = servico;
	}
	
	@Override
	public Long getId() {
		return idSubServico;
	}
	public void setId(Long id) {
		this.idSubServico = id;
	}
	public void setIdSubServico(Long idSubServico) {
		this.idSubServico = idSubServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public String getNomeTabela() {
		return nomeTabela;
	}
	public int getNumeroAtributosTabela() {
		return numeroAtributosTabela;
	}

}
