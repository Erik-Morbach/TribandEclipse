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
import com.integrador.model.Foto;
import com.integrador.model.Reserva;
import com.integrador.persistencia.BandaDAO;
import com.integrador.persistencia.FotoDAO;
import com.integrador.persistencia.Parser;

@SpringBootApplication
public class TribandApplication {

	public static void main(String[] args) {
		

		BandaDAO dao = new BandaDAO(new Banda());

		Banda a = dao.buscarPorId((long) 4);
		System.out.println(a.getId());
		System.out.println(a.getNome());
		System.out.println(a.getIntegrantes());
		System.out.println(a.getEmail());
		System.out.println(a.getSenha());
	/*;
		dao.deletar(1);
	FotoDAO fotoDAO = new FotoDAO(new Foto());
		
		Foto foto = fotoDAO.salvar(new Foto((long) 0,"teste3",null,null));
		
		AgendaDAO agendaDAO= new AgendaDAO(new Agenda());
		
		Agenda agenda = agendaDAO.salvar(new Agenda((long)0,null,null,new ArrayList<Reserva>()));
		
		Banda a = new Banda((long) 0,"jaja","sdf@gmail.com","1234",3,foto,agenda,new ArrayList<Foto>(),new ArrayList<AvaliacaoBanda>());
		

		a = dao.salvar(a);
		
		agenda.setBanda(a);
		foto.setBanda(a);
		
		agendaDAO.editar(agenda);
		fotoDAO.editar(foto);
		dao.editar(a);
		*/
		//SpringApplication.run(TribandApplication.class, args);
	}

}
