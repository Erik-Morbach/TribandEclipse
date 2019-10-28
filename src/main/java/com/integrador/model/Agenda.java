package com.integrador.model;

import java.util.ArrayList;

public class Agenda implements EntidadeBase{

	private Long idAgenda;
	private Estudio estudio;
	private Banda banda;
	private ArrayList<Reserva> reservas;
	private final String nomeTabela = "agenda";
	private final int numeroAtributosTabela = 3;
	

	public Agenda(Long idAgenda, Estudio estudio, Banda banda, ArrayList<Reserva> reservas) {
		super();
		this.idAgenda = idAgenda;
		this.estudio = estudio;
		this.banda = banda;
		this.reservas = reservas;
	}

	public Agenda() {
		super();
	}

	//GETS E SETS
	
	
	public Long getId() {
		return idAgenda;
	}

	public void setId(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public String getNomeTabela() {
		return nomeTabela;
	}

	public int getNumeroAtributosTabela() {
		return numeroAtributosTabela;
	}
	
	
	//OUTROS METODOS



	public Reserva addToAgenda(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}
	
}
