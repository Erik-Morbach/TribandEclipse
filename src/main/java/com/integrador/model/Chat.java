package com.integrador.model;

import java.util.ArrayList;

public class Chat extends EntidadeBase{

	private Banda banda;
	private Estudio estudio;
	private Long idChat;
	private ArrayList<Mensagem> mensagens;
	public Chat(Long idChat, Banda banda, Estudio estudio, ArrayList<Mensagem> mensagens) {
		this();
		this.idChat = idChat;
		this.banda = banda;
		this.estudio = estudio;
		this.mensagens = mensagens;

	}

	public Chat() {
		super();

		nomeTabela = "chat";
		numeroAtributosTabela = 3;
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

	public void addMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
