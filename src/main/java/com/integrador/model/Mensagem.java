package com.integrador.model;

import java.sql.Time;

public class Mensagem implements EntidadeBase{ 
//para atualizaçções futuras o sistema de mensagens sera melhorado
	
	
	private long idMensagem;
	private String mensagem;
	private Time horario;
	private Usuario remetente;
	private Usuario destinatario;
	private boolean recebeu;
	private boolean visualizou;
	private Chat chat;
	
	public Mensagem(){ super(); }
	public Mensagem(Long idMensagem, String mensagem, Time horario, Usuario remetente, Usuario destinatario,
			boolean recebeu, boolean visualizou, Chat chat) {
		super();
		this.idMensagem = idMensagem;
		this.mensagem = mensagem;
		this.horario = horario;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.recebeu = recebeu;
		this.visualizou = visualizou;
		this.chat = chat;
	}


	@Override
	public long getId() {
		return idMensagem;
	}
	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
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
	public boolean isRecebeu() {
		return recebeu;
	}
	public void setRecebeu(boolean recebeu) {
		this.recebeu = recebeu;
	}
	public boolean isVisualizou() {
		return visualizou;
	}
	public void setVisualizou(boolean visualizou) {
		this.visualizou = visualizou;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
	
	
	
	
}
