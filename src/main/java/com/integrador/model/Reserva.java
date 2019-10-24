package com.integrador.model;

import java.sql.Date;
import java.sql.Time;

public class Reserva implements EntidadeBase{

	private Long idReserva;
	private Date data;
	private Time horaInicio;
	private Time horaFinal;
	private Banda banda;
	private Agenda agenda;
	private String nomeTabela = "reserva";
	
	public Reserva() {
		super();
	}

	

	public Reserva(Long idReserva, Date data, Time horaInicio, Time horaFinal, Banda banda, Agenda agenda) {
		super();
		this.idReserva = idReserva;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.banda = banda;
		this.agenda = agenda;
	}



	//GETS E SETS
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.idReserva;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idReserva = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}
	public Banda getBanda() {
		return banda;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}



	public String getNomeTabela() {
		return nomeTabela;
	}



	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	
}
