package com.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.AvaliacaoEstudio;
import com.integrador.persistencia.AvaliacaoEstudioDAO;

@Controller
@RequestMapping("/valiacaoEstudio")
public class AvaliacaoEstudioController extends GenericoController<AvaliacaoEstudio,AvaliacaoEstudioDAO>{

	public AvaliacaoEstudioController() {
		super(new AvaliacaoEstudioDAO());
		// TODO Auto-generated constructor stub
	}

}
