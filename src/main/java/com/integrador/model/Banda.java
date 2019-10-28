package com.integrador.model;
import java.sql.Date;
import java.util.ArrayList;

public class Banda  implements Usuario, EntidadeBase{

	private Long idBanda;
	private String nome;
	private String email;
	private String senha;
	private Integer integrantes;
	private Foto fotoPerfil;
	private Agenda agenda;
	private ArrayList<Foto> fotos;
	private ArrayList<AvaliacaoBanda> avaliacoes;
	private final String nomeTabela = "banda";
	private final int numeroAtributosTabela=7;

	
	public Banda(Long idBanda, String nome, String email, String senha, Integer integrantes, Foto fotoPerfil, Agenda agenda,
			ArrayList<Foto> fotos, ArrayList<AvaliacaoBanda> avaliacoes) {
		super();
		this.idBanda = idBanda;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.integrantes = integrantes;
		this.fotoPerfil = fotoPerfil;
		this.fotos = fotos;
		this.avaliacoes = avaliacoes;
		this.agenda = agenda;
	}
	public Banda(){
		super();
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
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	//OUTROS METODOS
	


	public String getNomeTabela() {
		return nomeTabela;
	}
	public int getNumeroAtributosTabela() {
		return numeroAtributosTabela;
	}
	public AvaliacaoBanda addAvaliacao(AvaliacaoBanda av){
		this.avaliacoes.add(av);
		return av;
	}
	
	
	public AvaliacaoEstudio Avaliar(Integer limpeza,Integer qualiEquip,Integer compComHorario,Integer atendimento, Date data,Estudio estudio){
		AvaliacaoEstudio ave = new AvaliacaoEstudio(new Long(0),limpeza,qualiEquip,compComHorario,atendimento,data,estudio);
		estudio.addAvaliacao(ave);
		return ave;
	}
	
	public Reserva addReserva(Reserva reserva) {
		this.agenda.addToAgenda(reserva);
		return reserva;
	}

	
	

	
}
