package com.integrador.model;

public class Servico {

	private long idServicos;
	private String descricao;
	private Estudio estudio;
	
	public Servico(String descricao, Estudio estudio) {
		super();
		this.descricao = descricao;
		this.estudio = estudio;
	}
	
	public Servico() {
		super();
	}

	public long getIdServicos() {
		return idServicos;
	}

	public void setIdServicos(long idServicos) {
		this.idServicos = idServicos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}
	
}
