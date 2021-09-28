package com.prueba.model.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.model.entity.Usuario;
import com.prueba.model.service.IUsuarioService;


@Controller
@RequestMapping("/views")
public class RegisterController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	//@GetMapping({"/index","/home","/"})
	@GetMapping({"/"})
	public String registro(Model model) {
		Usuario usuario = new Usuario();
		Date fechaAct = new Date();
		usuario.setFecha_registro(fechaAct);
		model.addAttribute("usuarior", usuario);
		model.addAttribute("fecha_r", fechaAct);
		return "views/register";
	}
	
	@PostMapping("/registrar")
	public String guardar(@ModelAttribute Usuario user) {
		usuarioService.registrar(user);
		return "redirect:/index";
	}
	
}