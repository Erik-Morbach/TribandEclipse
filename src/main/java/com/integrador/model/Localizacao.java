package com.integrador.model;

public class Localizacao extends EntidadeBase {

	private String bairro;
	private Long cep;
	private String cidade;
	private String estado;
	private Long idLocalizacao;
	private Double latitude;
	private Double longitude;
	private Integer numero;
	private String rua;
	
	public Localizacao(Long idLocalizacao, Long cep, String estado, String cidade, String bairro, String rua,
			Integer numero, Double latitude, Double longitude) {
		this();
		this.idLocalizacao = idLocalizacao;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public Localizacao(){
		super();

		nomeTabela = "localizacao";
		numeroAtributosTabela = 9;
	}
	
	@Override
	public Long getId() {
		return idLocalizacao;
	}
	public void setId(Long id) {
		this.idLocalizacao = id;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
}
	