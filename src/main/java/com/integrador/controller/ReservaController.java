package com.integrador.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;
import com.integrador.model.Reserva;
import com.integrador.persistencia.ReservaDAO;

@Controller
@RequestMapping("/reserva")
public class ReservaController extends GenericoController<Reserva,ReservaDAO>{

	public ReservaController() {
		super(new ReservaDAO());
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/banda")
	public ResponseEntity<List<Reserva>> buscaPorBanda(@RequestBody Banda banda){
		return ResponseEntity.ok(t.buscaPorBanda(banda));
	}
	@GetMapping("/estudio")
	public ResponseEntity<List<Reserva>> buscaPorEstudio(@RequestBody Estudio estudio){
		return ResponseEntity.ok(t.buscaPorEstudio(estudio));
	}

	@GetMapping("/estudio/data")
	public ResponseEntity<List<Reserva>> buscaPorEstudioEData(@RequestBody Estudio estudio,@RequestParam Date data){
		return ResponseEntity.ok(t.buscaPorEstudioEData(estudio, data));
	}
	
}
