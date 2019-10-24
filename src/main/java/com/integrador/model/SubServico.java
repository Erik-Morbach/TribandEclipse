package com.integrador.model;

public class SubServico implements EntidadeBase {
	
	private Long idSubServico;
	private String descricao;
	private Servico servico;
	
	
	public SubServico(){ super(); }
	public SubServico(Long idSubServico, String descricao, Servico servico) {
		super();
		this.idSubServico = idSubServico;
		this.descricao = descricao;
		this.servico = servico;
	}
	
	@Override
	public long getId() {
		return idSubServico;
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
	

}
