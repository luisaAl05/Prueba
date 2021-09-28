package com.prueba.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prueba.model.entity.User;
import com.prueba.model.entity.Usuario;
import com.prueba.model.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	  @Autowired
	  UserRepository userRepository;
	  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//Buscar el usuario con el repositorio y si no existe lanzar una exepcion
	     User appUser =
	                 userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
	     
	     UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword());
         return user;
	}

}
