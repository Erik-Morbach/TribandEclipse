package com.integrador.model;
import java.sql.Date;
import java.util.ArrayList;

public class Banda extends EntidadeBase implements Usuario {

	private ArrayList<Reserva> reservas;
	private String email;
	private Foto fotoPerfil;
	private Long idBanda;
	private Integer integrantes;
	private String nome;
	private String senha;
	private String telefone;
	private ArrayList<Foto> fotos;
	private ArrayList<AvaliacaoBanda> avaliacoes;

	
	
	public Banda(ArrayList<Reserva> reservas, String email, Foto fotoPerfil, Long idBanda, Integer integrantes,
			String nome, String senha, String telefone, ArrayList<Foto> fotos, ArrayList<AvaliacaoBanda> avaliacoes) {
		this();
		this.reservas = reservas;
		this.email = email;
		this.fotoPerfil = fotoPerfil;
		this.idBanda = idBanda;
		this.integrantes = integrantes;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.fotos = fotos;
		this.avaliacoes = avaliacoes;
	}

	public Banda(){
		super();

		nomeTabela = "banda";
		numeroAtributosTabela = 7;
	}

	//GET E SETS
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
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.idBanda;
	}
	public void setId(Long id) {
		this.idBanda = id;
	}
 	public Integer getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(Integer integrantes) {
		this.integrantes = integrantes;
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
	public ArrayList<AvaliacaoBanda> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(ArrayList<AvaliacaoBanda> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
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

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	//OUTROS METODOS
	

	public AvaliacaoBanda addAvaliacao(AvaliacaoBanda av){
		this.avaliacoes.add(av);
		return av;
	}
	
	
	public AvaliacaoEstudio Avaliar(Integer limpeza,Integer qualidadeEquipamento,Integer compromissoHorario,Integer atendimento, Date data,Estudio estudio){
		AvaliacaoEstudio ave = new AvaliacaoEstudio(atendimento,compromissoHorario,data,estudio,(long)0,limpeza,qualidadeEquipamento);
		estudio.addAvaliacao(ave);
		return ave;
	}
	
	public Reserva addReserva(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}

	
	

	
}
