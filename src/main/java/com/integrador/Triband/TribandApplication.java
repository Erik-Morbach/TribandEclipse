package com.integrador.Triband;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.integrador.model.AvaliacaoBanda;
import com.integrador.model.Banda;
import com.integrador.model.EntidadeBase;
import com.integrador.model.Estudio;
import com.integrador.model.Foto;
import com.integrador.model.Reserva;
import com.integrador.persistencia.BandaDAO;
import com.integrador.persistencia.EstudioDAO;
import com.integrador.persistencia.FotoDAO;
import com.integrador.persistencia.GenericoDAO;
import com.integrador.persistencia.Parser;

@SpringBootApplication
public class TribandApplication {

	public static void main(String[] args) {

		EstudioDAO dao = new EstudioDAO();

		List<Estudio> b = dao.buscaPorProximidadeLocalizacaoPrecoHorarioDisponivel(-28.449293, -52.199451, (double) 3, null, null, null, null, EstudioDAO.ORDENAPORPRECO);
		for (Estudio a : b) {
			System.out.println(a.getId());
			System.out.println(a.getNome());
			System.out.println(a.getDescricao());
			System.out.println(a.getEmail());
			System.out.println(a.getSenha());
		}
		/*
		 * ; dao.deletar(1); FotoDAO fotoDAO = new FotoDAO(new Foto());
		 * 
		 * Foto foto = fotoDAO.salvar(new Foto((long) 0,"teste3",null,null));
		 * 
		 * AgendaDAO agendaDAO= new AgendaDAO(new Agenda());
		 * 
		 * Agenda agenda = agendaDAO.salvar(new Agenda((long)0,null,null,new
		 * ArrayList<Reserva>()));
		 * 
		 * Banda a = new Banda((long) 0,"jaja","sdf@gmail.com","1234",3,foto,agenda,new
		 * ArrayList<Foto>(),new ArrayList<AvaliacaoBanda>());
		 * 
		 * 
		 * a = dao.salvar(a);
		 * 
		 * agenda.setBanda(a); foto.setBanda(a);
		 * 
		 * agendaDAO.editar(agenda); fotoDAO.editar(foto); dao.editar(a);
		 */
		// SpringApplication.run(TribandApplication.class, args);
	}

}
