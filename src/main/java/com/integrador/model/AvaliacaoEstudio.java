package com.integrador.model;

import java.sql.Date;

public class AvaliacaoEstudio {

	private long idAvEstudio;
	private int limpeza;
	private int qualidadeEquip;
	private int compComHorario;
	private int atendimento;
	private Date data;
	private Banda banda;
	private Estudio estudio;
	
	public AvaliacaoEstudio(int limpeza, int qualidadeEquip, int compComHorario, int atendimento,
			Date data, Banda banda, Estudio estudio) {
		super();
		this.limpeza = limpeza;
		this.qualidadeEquip = qualidadeEquip;
		this.compComHorario = compComHorario;
		this.atendimento = atendimento;
		this.data = data;
		this.banda = banda;
		this.estudio = estudio;
	}

	//GETS E SETS
	
	public long getIdAvEstudio() {
		return idAvEstudio;
	}

	public void setIdAvEstudio(int idAvEstudio) {
		this.idAvEstudio = idAvEstudio;
	}

	public int getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(int limpeza) {
		this.limpeza = limpeza;
	}

	public int getQualidadeEquip() {
		return qualidadeEquip;
	}

	public void setQualidadeEquip(int qualidadeEquip) {
		this.qualidadeEquip = qualidadeEquip;
	}

	public int getCompComHorario() {
		return compComHorario;
	}

	public void setCompComHorario(int compComHorario) {
		this.compComHorario = compComHorario;
	}

	public int getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(int atendimento) {
		this.atendimento = atendimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
	
	//OUTROS METODOS
	
}