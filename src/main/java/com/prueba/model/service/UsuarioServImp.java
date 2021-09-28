package com.prueba.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.model.DAO.IUsuarioDao;
import com.prueba.model.entity.Usuario;
import com.prueba.model.repository.UsuarioRepository;

@Service
public class UsuarioServImp implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRep.findAll();
	}

	@Override
	public void registrar(Usuario usuario) {
		usuarioRep.save(usuario);

	}

	@Override
	public Usuario buscar(String correo_electronico, String contraseña) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByCorreoelectronico(String correoelectronico) {
		// TODO Auto-generated method stub
		return null;
	}

}
