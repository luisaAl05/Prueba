package com.prueba.model.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prueba.model.entity.Usuario;


@Controller
public class HomeController {
	
	//@GetMapping({"/index","/home","/"})
	@GetMapping({"/index"})
	public String index(Model model) {
		Usuario usuario = new Usuario();
		Date fechaAct = new Date();
		usuario.setUltima_conexion(fechaAct);
		model.addAttribute("usuarior", usuario);
		model.addAttribute("fecha_r", fechaAct);
		return "home";
	}
	
}
