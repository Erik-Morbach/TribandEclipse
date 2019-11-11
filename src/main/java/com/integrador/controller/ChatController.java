package com.integrador.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.model.Chat;
import com.integrador.persistencia.ChatDAO;

@Controller
@RequestMapping("/chat")
public class ChatController extends GenericoController<Chat,ChatDAO>{

	public ChatController() {
		super(new ChatDAO());
		// TODO Auto-generated constructor stub
	}

}
