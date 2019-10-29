package com.integrador.controller;

import org.springframework.stereotype.Controller;

import com.integrador.model.Chat;
import com.integrador.persistencia.ChatDAO;

@Controller
public class ChatController extends GenericoController<Chat,ChatDAO>{

}
