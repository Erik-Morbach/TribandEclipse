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

	//OUTROS METODOS
	
	public void setAvaliacao(AvaliacaoBanda av){
		this.avaliacoes.add(av);
	}
	
	public ArrayList<AvaliacaoBanda> verAvaliacao() {
		return this.avaliacoes;
	}
	
	public void Avaliar(int limpeza,int qualiEquip,int compComHorario,int atendimento, Date data,Estudio estudio){
		AvaliacaoEstudio ave = new AvaliacaoEstudio(limpeza,qualiEquip,compComHorario,atendimento,data,this,estudio);
		estudio.setAvaliacao(ave);
	}
	
	public void addReserva(Reserva reserva) {
		this.agenda.addToAgenda(reserva);
	}
	
}
