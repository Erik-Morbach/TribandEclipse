package com.integrador.model;

public class Foto extends EntidadeBase {

	private Banda banda;
	private Estudio estudio;
	private Long idFoto;
	private String path;

	public Foto() {
		super();

		nomeTabela = "foto";
		numeroAtributosTabela = 4;
	}

	public Foto(Long idFoto, String path, Banda banda, Estudio estudio) {
		this();
		this.idFoto = idFoto;
		this.path = path;
		this.banda = banda;
		this.estudio = estudio;

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idFoto;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idFoto = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

}
