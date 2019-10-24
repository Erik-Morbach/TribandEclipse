package com.integrador.model;

import java.sql.Time;

public class Mensagem implements EntidadeBase{ 
//para atualizaçções futuras o sistema de mensagens sera melhorado
	
	
	private Long idMensagem;
	private String mensagem;
	private Time horario;
	private Chat chat;
	private String nomeTabela = "mensagem";
	
	public Mensagem(){ super(); }
	public Mensagem(Long idMensagem, String mensagem, Time horario, Chat chat) {
		super();
		this.idMensagem = idMensagem;
		this.mensagem = mensagem;
		this.horario = horario;
		this.chat = chat;
	}




	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.idMensagem;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idMensagem = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public String getNomeTabela() {
		return nomeTabela;
	}
	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

}
