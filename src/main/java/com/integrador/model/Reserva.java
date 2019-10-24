package com.integrador.model;

import java.sql.Date;
import java.sql.Time;

public class Reserva implements EntidadeBase{

	private long idReserva;
	private Date data;
	private Time horaInicio;
	private Time horaFinal;
	private Banda banda;
	private Estudio estudio;
	private Agenda agenda;
	
	public Reserva(Date data, Time horaInicio, Time horaFinal, Banda banda, Estudio estudio, Agenda agenda) {
		super();
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.banda = banda;
		this.estudio = estudio;
		this.agenda = agenda;
	}
	
	public Reserva() {
		super();
	}
	
	@Override
	public long getId() {
		return idReserva;
	}

	//GETS E SETS
	
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
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

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
}
