package com.integrador.model;

public class Localizacao {

	private long idLocalizacao;
	private long cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private Double lagitude;
	private Double longitude;
	
	public Localizacao(long idLocalizacao, long cep, String estado, String cidade, String bairro, String rua,
			int numero, Double lagitude, Double longitude) {
		super();
		this.idLocalizacao = idLocalizacao;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.lagitude = lagitude;
		this.longitude = longitude;
	}
	
	public Localizacao(){
		
	}

	public long getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(long idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Double getLagitude() {
		return lagitude;
	}

	public void setLagitude(Double lagitude) {
		this.lagitude = lagitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	