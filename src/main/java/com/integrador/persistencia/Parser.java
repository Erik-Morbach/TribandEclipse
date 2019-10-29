package com.integrador.persistencia;

import java.lang.reflect.Field;

import org.springframework.data.util.Pair;

import com.integrador.model.EntidadeBase;

import antlr.collections.List;

public class Parser {
	public Parser() {
		
	}
	// Retorna o nome do atributo no banco e se é uma chave estrangeira
	public Pair<String,Boolean> geraNome(Field w) {
		Pair<String,Boolean> resposta = null;
		
		if(List.class.isAssignableFrom(w.getClass())) return resposta;
		
		String first = "";
		Boolean second = false;
		if(EntidadeBase.class.isAssignableFrom(w.getClass())) {
			second = true;
			first +="id_";
		}
		char[] nomeAtributo = w.getName().toCharArray();
		for(char k: nomeAtributo) {
			if(Character.isUpperCase(k)) first+="_";
			first+=Character.toLowerCase(k);
		}
		

		resposta = Pair.of(first, second);
		return resposta;
	}
	
	public Pair<String,Object> geraNomeObjeto(Field w, Object q){
		Pair<String,Boolean> nome = geraNome(w);
		Pair<String,Object> resposta = null;
	
		if(nome==null) return resposta;
		
		String first = nome.getFirst();
		Object second = q;
	
		if(nome.getSecond()) {
			second = ((EntidadeBase)q).getId();
		}
		
		resposta = Pair.of(first, second);
		return resposta;
	}
	
	
	
}
