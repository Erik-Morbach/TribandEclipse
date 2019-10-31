package com.integrador.persistencia;

import java.lang.reflect.Field;

import org.hibernate.validator.internal.util.privilegedactions.GetDeclaredField;
import org.springframework.data.util.Pair;

import com.integrador.model.EntidadeBase;

import java.util.ArrayList;
import java.util.List;

public class Parser<T extends EntidadeBase> {
	T auxiliar;
	public Parser(T obj) {
		auxiliar = obj;
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


	public String geraInnerJoin(T aux) throws IllegalArgumentException, IllegalAccessException {
		String ans = "";
		Field atributos[] = aux.getClass().getDeclaredFields();
		for(Field w: atributos) {
			w.setAccessible(true);
			if(ehChaveEstrangeira(w)) {
				String nome = geraNome(w).substring(3); // Como é chave estrangeira começa com id_****; 
				
				ans +=  " INNER JOIN "+nome+" ON "+nome+".id_"+nome+"="+aux.getNomeTabela()+".id_"+nome; 
				
			}
		}
		
		return ans;
	}

	public String[] geraNomeAtributos(Field[] atributos, int tamanhoClasse) {
		int idx = 0;
		String nomes[] = new String[tamanhoClasse];
		int tamanho = atributos.length;
		for(int i=0;i<tamanho;i++) {
			atributos[i].setAccessible(true);       // necessario para podermos pegar o valor do atributo
			String ans = geraNome(atributos[i]);
			nomes[idx++] = ans;
		}	
		
		// TODO Auto-generated method stub
		return nomes;
	}
	
	public Field geraAtributo(String nome) {
		try {
			Field ans = auxiliar.getClass().getDeclaredField(nome);
			ans.setAccessible(true);
			return ans;
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
