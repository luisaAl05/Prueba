package com.prueba.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.model.entity.Usuario;
import com.prueba.model.service.IUsuarioService;

@Controller
@RequestMapping("/views")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuariosService;
	
	@GetMapping({"/usuarios"})
	public String usuario(Model modelo) {
		List<Usuario> lUsuarios = usuariosService.listarUsuarios();
		modelo.addAttribute("listaUsuarios", lUsuarios);
		return "views/usuarios";
	}
}
