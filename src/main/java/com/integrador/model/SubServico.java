package com.integrador.model;

public class SubServico extends EntidadeBase {

	private String descricao;
	private Long idSubservico;
	private Servico servico;

	public SubServico() {
		super();

		nomeTabela = "subservico";
		numeroAtributosTabela = 3;
	}

	public SubServico(Long idSubServico, String descricao, Servico servico) {
		this();
		this.idSubservico = idSubServico;
		this.descricao = descricao;
		this.servico = servico;

	}

	@Override
	public Long getId() {
		return idSubservico;
	}

	public void setId(Long id) {
		this.idSubservico = id;
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
