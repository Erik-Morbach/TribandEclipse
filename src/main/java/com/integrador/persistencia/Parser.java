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
	private String geraNome(String w) {
		String ans = "";
		char[] nomeAtributo = w.toCharArray();
		for (char k : nomeAtributo) {
			if (Character.isUpperCase(k))
				ans += "_";
			ans += Character.toLowerCase(k);
		}
		return ans;
	}
	public String geraNome(Field w) {
		String resposta = null;
		
		
		if (List.class.isAssignableFrom(w.getType())) {
			return resposta;
		}

		resposta = "";

		if (ehChaveEstrangeira(w)) {
			resposta += "id_"+geraNome(w.getType().getSimpleName().toLowerCase());
		} else {
			resposta += geraNome(w.getName());
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
