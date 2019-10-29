package com.integrador.model;

import java.sql.Time;

public class Mensagem extends EntidadeBase {
//para atualizaçções futuras o sistema de mensagens sera melhorado

	private Chat chat;
	private Time horario;
	private Long idMensagem;
	private String conteudo;

	public Mensagem() {
		super();

		nomeTabela = "mensagem";
		numeroAtributosTabela = 4;
	}


	public Mensagem(Chat chat, Time horario, Long idMensagem, String conteudo) {
		this();
		this.chat = chat;
		this.horario = horario;
		this.idMensagem = idMensagem;
		this.conteudo = conteudo;

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


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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

}
