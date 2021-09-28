package com.prueba.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.prueba.model.entity.User;
import com.prueba.model.entity.Usuario;

public interface UserRepository extends CrudRepository<User, Long> {
	  public Optional<User> findByUsername(String username);
		// TODO Auto-generated method stub
}
