package com.integrador.model;

import java.sql.Date;

public class AvaliacaoBanda implements EntidadeBase{

	private Long idAvBanda;
	private Integer compComHorario;
	private Integer cuidadoComEquipamento;
	private Date dataAvBanda;
	private Banda banda;
	private String nomeTabela = "avaliacao_banda";
	

	public AvaliacaoBanda(Long idAvBanda, Integer compComHorario, Integer cuidadoComEquipamento, Date dataAvBanda,
			Banda banda) {
		super();
		this.idAvBanda = idAvBanda;
		this.compComHorario = compComHorario;
		this.cuidadoComEquipamento = cuidadoComEquipamento;
		this.dataAvBanda = dataAvBanda;
		this.banda = banda;
	}

	public AvaliacaoBanda() {
		super();
	}

	//GETS E SETS;
	
	@Override
	public Long getId() {
		return idAvBanda;
	}

	public void setId(Long idAvBanda) {
		this.idAvBanda = idAvBanda;
	}

	public Integer getCompComHorario() {
		return compComHorario;
	}

	public void setCompComHorario(Integer compComHorario) {
		this.compComHorario = compComHorario;
	}

	public Integer getCuidadoComEquipamento() {
		return cuidadoComEquipamento;
	}

	public void setCuidadoComEquipamento(Integer cuidadoComEquipamento) {
		this.cuidadoComEquipamento = cuidadoComEquipamento;
	}

	public Date getDataAvBanda() {
		return dataAvBanda;
	}

	public void setDataAvBanda(Date dataAvBanda) {
		this.dataAvBanda = dataAvBanda;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

}