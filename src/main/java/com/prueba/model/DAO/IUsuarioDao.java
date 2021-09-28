package com.prueba.model.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	public Usuario findByCorreoelectronico(String correoelectronico);
}
