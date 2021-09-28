package com.prueba.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class DashboardController {

@GetMapping({"/dashboard"})
	public String pintar() {
		return "views/Dashboard";
	}
}
