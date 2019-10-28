package com.integrador.model;

import java.util.ArrayList;

public class Chat implements EntidadeBase{

	private Long idChat;
	private Banda banda;
	private Estudio estudio;
	private ArrayList<Mensagem> mensagens;
	private final String nomeTabela = "chat";
	private final int numeroAtributosTabela=3;

	public Chat(Long idChat, Banda banda, Estudio estudio, ArrayList<Mensagem> mensagens) {
		super();
		this.idChat = idChat;
		this.banda = banda;
		this.estudio = estudio;
		this.mensagens = mensagens;
	}

	public Chat() {
		super();
	}

	@Override
	public Long getId(){
		return this.idChat;
	}
	public void setId(Long id) {
		this.idChat = id;
	}
	
	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
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

	public String getNomeTabela() {
		return nomeTabela;
	}

	public int getNumeroAtributosTabela() {
		return numeroAtributosTabela;
	}

	public void addMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
