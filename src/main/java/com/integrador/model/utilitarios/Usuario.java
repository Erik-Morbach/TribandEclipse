package com.integrador.model.utilitarios;

import com.integrador.model.classes.Foto;

public interface Usuario{


	
	public String getNome() ;

	public void setNome(String nome) ;

	public String getEmail();

	public void setEmail(String email);

	public String getSenha() ;

	public void setSenha(String senha) ;
	
	

	public Foto getFotoPerfil();
	public void setFotoPerfil(Foto foto);
}