package com.integrador.model;
import java.sql.Date;
import java.util.ArrayList;

public class Banda extends Usuario{

	private long idBanda;
	private int integrantes;
	private ArrayList<String> fotos;
	private ArrayList<AvaliacaoBanda> avaliacoes;
	private Agenda agenda;
	
	public Banda(String nome, String email, String senha, int integrantes, ArrayList<String> fotos) {
		super(nome, email, senha);
		this.integrantes = integrantes;
		this.fotos = fotos;
	}
	
	public Banda(){
		super();
	}

	//GET E SETS
	
	public int getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(int integrantes) {
		this.integrantes = integrantes;
	}

	public ArrayList<String> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
	}
	

	public ArrayList<AvaliacaoBanda> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<AvaliacaoBanda> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	//OUTROS METODOS
	

	public AvaliacaoBanda addAvaliacao(AvaliacaoBanda av){
		this.avaliacoes.add(av);
		return av;
	}
	
	
	public AvaliacaoEstudio Avaliar(int limpeza,int qualiEquip,int compComHorario,int atendimento, Date data,Estudio estudio){
		AvaliacaoEstudio ave = new AvaliacaoEstudio(limpeza,qualiEquip,compComHorario,atendimento,data,this,estudio);
		estudio.addAvaliacao(ave);
		return ave;
	}
	
	public Reserva addReserva(Reserva reserva) {
		this.agenda.addToAgenda(reserva);
		return reserva;
	}
	
}
