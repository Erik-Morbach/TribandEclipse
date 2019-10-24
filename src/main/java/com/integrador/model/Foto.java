package com.integrador.model;

public class Foto implements EntidadeBase {
	private Long idFoto;
	private String path;
	private Banda banda;
	private Estudio estudio;
	private String nomeTabela = "foto";
	
	public Foto() { super(); }
	public Foto(Long idFoto, String path, Banda banda, Estudio estudio) {
		super();
		this.idFoto = idFoto;
		this.path = path;
		this.banda = banda;
		this.estudio = estudio;
	}




	
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
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
	public String getNomeTabela() {
		return nomeTabela;
	}
	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

}
