package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;
import com.integrador.model.Foto;
import com.integrador.persistencia.FotoDAO;

@Controller
@RequestMapping("/foto")
public class FotoController extends GenericoController<Foto,FotoDAO>{

	public FotoController() {
		super(new FotoDAO());
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/banda")
	public ResponseEntity<List<Foto>> buscaPorBanda(@RequestBody Banda banda){
		return ResponseEntity.ok(t.buscaPorBanda(banda));
	}
	
	@GetMapping("/estudio")
	public ResponseEntity<List<Foto>> buscaPorEstudio(@RequestBody Estudio estudio){
		return ResponseEntity.ok(t.buscaPorEstudio(estudio));
	}
	
	
	
}
