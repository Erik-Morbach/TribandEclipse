package com.integrador.Triband;

import java.lang.reflect.Field;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.integrador.model.Agenda;
import com.integrador.model.Banda;
import com.integrador.model.Foto;
import com.integrador.persistencia.AgendaDAO;
import com.integrador.persistencia.BandaDAO;
import com.integrador.persistencia.FotoDAO;

@SpringBootApplication
public class TribandApplication {

	public static void main(String[] args) {
		BandaDAO dao = new BandaDAO();
		FotoDAO fotoDAO = new FotoDAO();
		
		Foto foto = fotoDAO.Salvar(new Foto((long) 0,"zib",null,null));
		
		AgendaDAO agendaDAO= new AgendaDAO();
		
		Agenda agenda = agendaDAO.Salvar(new Agenda((long)0,null,null,null));
		
		Banda a = new Banda((long) 0,"Ate Fevereiro","nemzeil@gmail.com","1234",3,foto,agenda,null,null);
		
		
		dao.Salvar(a);
		
		//SpringApplication.run(TribandApplication.class, args);
	}

}
