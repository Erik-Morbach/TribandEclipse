package com.integrador.controller;

import org.springframework.stereotype.Controller;

import com.integrador.model.Agenda;
import com.integrador.persistencia.AgendaDAO;

@Controller
public class AgendaController extends GenericoController<Agenda,AgendaDAO> {


}
