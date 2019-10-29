package com.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.integrador.model.Banda;
import com.integrador.persistencia.BandaDAO;

@Controller
public class BandaController extends GenericoController<Banda,BandaDAO>{

	//BUSCAR POR EMAIL
	
	@GetMapping("/{email}")
	public ResponseEntity<Banda> buscarPorEmail(@PathVariable String email) {
		return ResponseEntity.ok(super.t.buscarPorEmail(email));
	}
	
	
}
