package com.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.integrador.model.Localizacao;
import com.integrador.persistencia.LocalizacaoDAO;

@Controller
public class LocalizacaoController extends GenericoController<Localizacao,LocalizacaoDAO>{

	@GetMapping("/localizacao")
	public ResponseEntity<List<Localizacao>> buscarPorProximidade(@RequestBody Localizacao localizacao){
		return ResponseEntity.ok(super.t.buscarPorProximidade(localizacao));
	}
	
	
	
}
