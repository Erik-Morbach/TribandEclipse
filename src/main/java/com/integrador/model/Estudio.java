package com.integrador.model;

import java.sql.Date;
import java.util.ArrayList;

public class Estudio extends EntidadeBase implements Usuario {

	private ArrayList<Reserva> reservas;
	private String cnpj;
	private String email;
	private Foto fotoPerfil;
	private Long idEstudio;
	private Localizacao localizacao;
	private String nome;
	private String senha;
	private String telefone;
	private String descricao;
	private ArrayList<Foto> fotos;
	private ArrayList<AvaliacaoEstudio> avaliacoes;
	private ArrayList<Servico> servicos;
	
	
	public Estudio(ArrayList<Reserva> reservas, String cnpj, String email, Foto fotoPerfil, Long idEstudio,
			Localizacao localizacao, String nome, String senha, String telefone, String descricao,
			ArrayList<Foto> fotos, ArrayList<AvaliacaoEstudio> avaliacoes, ArrayList<Servico> servicos) {
		this();
		this.reservas = reservas;
		this.cnpj = cnpj;
		this.email = email;
		this.fotoPerfil = fotoPerfil;
		this.idEstudio = idEstudio;
		this.localizacao = localizacao;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.descricao = descricao;
		this.fotos = fotos;
		this.avaliacoes = avaliacoes;
		this.servicos = servicos;
	}

	public Estudio(){
		super();
		nomeTabela = "estudio";
		numeroAtributosTabela = 8;
	}
	
	//GET E SETS

	@Override
	public Long getId(){
		return this.idEstudio;
	}
	public void setId(Long idEstudio) {
		this.idEstudio = idEstudio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public Foto getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public ArrayList<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}
	public ArrayList<AvaliacaoEstudio> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(ArrayList<AvaliacaoEstudio> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public ArrayList<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}
	public ArrayList<Reserva> getReservas() {
		return this.reservas;
	}
	public void setAgenda(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	//OUTROS METODOS


	public Servico addServico(Servico novo) {
		this.servicos.add(novo);
		return novo;
	}
	public void removeServico(int indice){
		this.servicos.remove(indice);
	}
	
	public Servico editServico(int indice, Servico novo){
		this.servicos.remove(indice);
		this.servicos.add(indice,novo);
		return novo;
	}
	
	public AvaliacaoBanda Avaliar(int compromissoHorario,int cuidadoEquipamento, Date dataAvaliacaoBanda,Banda banda){
		AvaliacaoBanda avb = new AvaliacaoBanda(banda,compromissoHorario,cuidadoEquipamento,dataAvaliacaoBanda,(long)0);
		banda.addAvaliacao(avb);
		return avb;
	}
	
	public AvaliacaoEstudio addAvaliacao(AvaliacaoEstudio ave){
		this.avaliacoes.add(ave);
		return ave;
	}
	
	public Reserva addReserva(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}
	
}

