package com.integrador.controller;

import org.springframework.stereotype.Controller;

import com.integrador.model.Mensagem;
import com.integrador.persistencia.MensagemDAO;

@Controller
public class MensagemController extends GenericoController<Mensagem,MensagemDAO>{

}
