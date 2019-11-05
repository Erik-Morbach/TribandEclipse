package com.integrador.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.integrador.model.Reserva;
import com.integrador.persistencia.ReservaDAO;

@Controller
public class ReservaController extends GenericoController<Reserva,ReservaDAO>{

	
}
