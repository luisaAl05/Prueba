package com.prueba.model.service;

import java.util.List;

import com.prueba.model.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios();
	public void registrar(Usuario usuario);
	public Usuario buscar(String correo_electronico, String contraseña);
	public Usuario findByCorreoelectronico(String correoelectronico);
}
