package com.integrador.controller;

import org.springframework.stereotype.Controller;

import com.integrador.model.Servico;
import com.integrador.persistencia.ServicoDAO;

@Controller
public class ServicoController extends GenericoController<Servico,ServicoDAO>{

}
