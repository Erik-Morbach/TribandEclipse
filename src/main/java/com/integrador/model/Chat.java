package com.integrador.model;

import java.util.ArrayList;

public class Chat {

	private long idChat;
	private ArrayList<String> mensagens;
	private Usuario usuario1;
	private Usuario usuario2;
	
	public Chat(ArrayList<String> mensagens, Usuario usuario1, Usuario usuario2) {
		super();
		this.mensagens = mensagens;
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
	}
	
	public Chat() {
		super();
	}

	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<String> mensagens) {
		this.mensagens = mensagens;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public void addMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
