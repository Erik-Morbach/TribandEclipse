package com.integrador.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.AvaliacaoBanda;
import com.integrador.persistencia.AvaliacaoBandaDAO;

@Controller
@RequestMapping("/avaliacaoBanda")
public class AvaliacaoBandaController extends GenericoController<AvaliacaoBanda,AvaliacaoBandaDAO>{

	public AvaliacaoBandaController() {
		super(new AvaliacaoBandaDAO());
	}

	
	
	
}
