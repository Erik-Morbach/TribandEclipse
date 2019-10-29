package com.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;
import com.integrador.persistencia.EstudioDAO;

@Controller
public class EstudioController extends GenericoController<Estudio,EstudioDAO>{

	//BUSCAR POR EMAIL
	
	@GetMapping("/{email}")
	public ResponseEntity<Estudio> buscarPorEmail(@PathVariable String email) {
		return ResponseEntity.ok(super.t.buscarPorEmail(email));
	}
	

	
}
