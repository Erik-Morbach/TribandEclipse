package com.integrador.model;

import java.util.ArrayList;

public class Servico {

	private long idServicos;
	private String descricao;
	private Estudio estudio;
	private ArrayList<SubServico> subServicos;
	
	

	public Servico() {
		super();
	}
	public Servico(String descricao, Estudio estudio, ArrayList<SubServico> subServicos) {
		super();
		this.descricao = descricao;
		this.estudio = estudio;
		this.subServicos = subServicos;
	}


	public long getIdServicos() {
		return idServicos;
	}

	public void setIdServicos(long idServicos) {
		this.idServicos = idServicos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}
	public ArrayList<SubServico> getSubServicos() {
		return subServicos;
	}
	public void setSubServicos(ArrayList<SubServico> subServicos) {
		this.subServicos = subServicos;
	}
	
	
	// Outros Metodos
	public SubServico addSubServico(SubServico novo){
		this.subServicos.add(novo);
		return novo;
	}
	
	public void removeSubServico(int indice){
		this.subServicos.remove(indice);
	}

	public SubServico editServico(int indice, SubServico novo){
		this.subServicos.remove(indice);
		this.subServicos.add(indice,novo);
		return novo;
	}
	
}
