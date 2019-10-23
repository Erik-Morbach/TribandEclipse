package com.integrador.model;

import java.util.ArrayList;

public class Agenda {

	private long idAgenda;
	private Usuario usuario;
	private ArrayList<Reserva> reservas;
	
	public Agenda(Usuario usuario, ArrayList<Reserva> reservas) {
		super();
		this.usuario = usuario;
		this.reservas = reservas;
	}
	
	public Agenda() {
		super();
	}

	//GETS E SETS
	
	
	public long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	//OUTROS METODOS
	
	public Reserva addToAgenda(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}
	
}
