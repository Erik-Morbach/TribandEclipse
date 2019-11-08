package com.integrador.model;

import java.util.ArrayList;
@Tabela(nome="chat")
public class Chat extends EntidadeBase{

	@Atributo(nome="banda",tipo=EntidadeBase.class)
	private Banda banda;
	

	@Atributo(nome="estudio",tipo=EntidadeBase.class)
	private Estudio estudio;

	@Atributo(nome="id_chat",tipo=Long.class)
	private Long idChat;
	
	private ArrayList<Mensagem> mensagens;
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

	public void addMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
