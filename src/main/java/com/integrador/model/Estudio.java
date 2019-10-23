package com.integrador.model;

import java.sql.Date;
import java.util.ArrayList;

public class Estudio extends Usuario {

	private long idEstudio;
	private String cnpj;
	private Localizacao localizacao;
	private ArrayList<String> fotos;
	private ArrayList<AvaliacaoEstudio> avaliacoes;
	private ArrayList<Servico> servicos;
	private Agenda agenda;
	
	public Estudio(String nome, String email, String senha, String cnpj, Localizacao localizacao, ArrayList<String> fotos) {
		super(nome, email, senha);
		this.cnpj = cnpj;
		this.localizacao = localizacao;
		this.fotos = fotos;
	}
	
	public Estudio(){
		super();
	}
	
	//GET E SETS

	public ArrayList<Servico> getServicos(){
		return this.servicos;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public ArrayList<String> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
	}
	
	//OUTROS METODOS
	
	public void setServico(String descricao) {
		Servico servico = new Servico(descricao,this);
		this.servicos.add(servico);
	}
	
	
	public void Avaliar(int compH,int cuidEquip, Date data,Banda banda){
		AvaliacaoBanda avb = new AvaliacaoBanda(compH,cuidEquip,data,banda,this);
		banda.setAvaliacao(avb);
	}
	
	public void setAvaliacao(AvaliacaoEstudio ave){
		this.avaliacoes.add(ave);
		}
	
	public void addReserva(Reserva reserva) {
		this.agenda.addToAgenda(reserva);
	}
	
}

