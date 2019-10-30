package com.integrador.model;

import java.sql.Date;
import java.sql.Time;

public class Reserva extends EntidadeBase{

	private Estudio estudio;
	private Banda banda;
	private Date dataReserva;
	private Time horarioFinal;
	private Time horarioInicio;
	private Long idReserva;
	
	public Reserva() {
		super();

		nomeTabela = "reserva";
		numeroAtributosTabela = 6;
	}
	



	public Reserva(Estudio agenda, Banda banda, Date dataReserva, Time horarioFinal, Time horarioInicio,
			Long idReserva) {
		this();
		this.estudio = agenda;
		this.banda = banda;
		this.dataReserva = dataReserva;
		this.horarioFinal = horarioFinal;
		this.horarioInicio = horarioInicio;
		this.idReserva = idReserva;
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
	public Date getDataReserva() {
		return dataReserva;
	}




	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}




	public Time getHorarioFinal() {
		return horarioFinal;
	}




	public void setHorarioFinal(Time horarioFinal) {
		this.horarioFinal = horarioFinal;
	}




	public Time getHorarioInicio() {
		return horarioInicio;
	}




	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
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
	public void setEstudio(Estudio agenda) {
		this.estudio = agenda;
	}
	
}
