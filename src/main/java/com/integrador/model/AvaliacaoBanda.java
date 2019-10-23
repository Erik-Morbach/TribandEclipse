package com.integrador.model;

import java.sql.Date;

public abstract class AvaliacaoBanda {

	private long idAvBanda;
	private int compComHorario;
	private int cuidadoComEquipamento;
	private Date dataAvBanda;
	private Banda banda;
	private Estudio estudio;
	
	public AvaliacaoBanda(int compComHorario, int cuidadoComEquipamento, Date dataAvBanda, Banda banda,
			Estudio estudio) {
		super();
		this.compComHorario = compComHorario;
		this.cuidadoComEquipamento = cuidadoComEquipamento;
		this.dataAvBanda = dataAvBanda;
		this.banda = banda;
		this.estudio = estudio;
	}

	public AvaliacaoBanda() {
		super();
	}

	//GETS E SETS;
	
	public long getIdAvBanda() {
		return idAvBanda;
	}

	public void setIdAvBanda(int idAvBanda) {
		this.idAvBanda = idAvBanda;
	}

	public int getCompComHorario() {
		return compComHorario;
	}

	public void setCompComHorario(int compComHorario) {
		this.compComHorario = compComHorario;
	}

	public int getCuidadoComEquipamento() {
		return cuidadoComEquipamento;
	}

	public void setCuidadoComEquipamento(int cuidadoComEquipamento) {
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

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}
}