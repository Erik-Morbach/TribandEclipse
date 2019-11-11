package com.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Estudio;
import com.integrador.persistencia.EstudioDAO;

@Controller
@RequestMapping("/estudio")
public class EstudioController extends GenericoController<Estudio,EstudioDAO>{

	public EstudioController() {
		super(new EstudioDAO());
		// TODO Auto-generated constructor stub
	}

	//BUSCAR POR EMAIL
	
	@GetMapping("/{email}")
	public ResponseEntity<Estudio> buscarPorEmail(@PathVariable String email) {
		return ResponseEntity.ok(super.t.buscarPorEmail(email));
	}
	

	
}
