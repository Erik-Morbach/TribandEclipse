package com.integrador.persistencia;

import java.lang.reflect.Field;

import org.springframework.data.util.Pair;

import com.integrador.model.EntidadeBase;

import java.util.List;

public class Parser {
	public Parser() {
	}

	public boolean ehChaveEstrangeira(Field w) {
	//	System.out.println(w.getType());
		return EntidadeBase.class.isAssignableFrom(w.getType());
	}

	// Retorna o nome do atributo no banco e se é uma chave estrangeira
	public String geraNome(Field w) {
		String resposta = null;
		
		
		if (List.class.isAssignableFrom(w.getType())) {
			return resposta;
		}

		resposta = "";

		if (ehChaveEstrangeira(w)) {
			resposta += "id_"+w.getType().getSimpleName().toLowerCase();
		} else {
			char[] nomeAtributo = w.getName().toCharArray();
			for (char k : nomeAtributo) {
				if (Character.isUpperCase(k))
					resposta += "_";
				resposta += Character.toLowerCase(k);
			}
		}
		return resposta;
	}

	public Object geraObjeto(Field w, Object q) {
	
		try {
			Object ans = w.get(q);
			if (ans == null) {
				return ans;
			}

			if (ehChaveEstrangeira(w)) {
				ans = ((EntidadeBase) ans).getId();

			}

			return ans;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
