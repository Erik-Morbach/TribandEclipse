package com.integrador.model;

import java.sql.Date;

public class AvaliacaoEstudio implements EntidadeBase{

	private Long idAvEstudio;
	private Integer limpeza;
	private Integer qualidadeEquip;
	private Integer compComHorario;
	private Integer atendimento;
	private Date data;
	private Estudio estudio;
	private final String nomeTabela = "avaliacao_estudio";
	private final int numeroAtributosTabela=7;
	
	
	public AvaliacaoEstudio() { super(); } 
	public AvaliacaoEstudio(Long idAvEstudio, Integer limpeza, Integer qualidadeEquip, Integer compComHorario,
			Integer atendimento, Date data, Estudio estudio) {
		super();
		this.idAvEstudio = idAvEstudio;
		this.limpeza = limpeza;
		this.qualidadeEquip = qualidadeEquip;
		this.compComHorario = compComHorario;
		this.atendimento = atendimento;
		this.data = data;
		this.estudio = estudio;
	}


	//GETS E SETS
	
	@Override
	public Long getId() {
		return idAvEstudio;
	}

	public void setId(Long idAvEstudio) {
		this.idAvEstudio = idAvEstudio;
	}

	public Integer getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(Integer limpeza) {
		this.limpeza = limpeza;
	}

	public Integer getQualidadeEquip() {
		return qualidadeEquip;
	}

	public void setQualidadeEquip(Integer qualidadeEquip) {
		this.qualidadeEquip = qualidadeEquip;
	}

	public Integer getCompComHorario() {
		return compComHorario;
	}

	public void setCompComHorario(Integer compComHorario) {
		this.compComHorario = compComHorario;
	}

	public Integer getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Integer atendimento) {
		this.atendimento = atendimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}


	public String getNomeTabela() {
		return nomeTabela;
	}

	public int getNumeroAtributosTabela() {
		return numeroAtributosTabela;
	}

	
	//OUTROS METODOS
	
}