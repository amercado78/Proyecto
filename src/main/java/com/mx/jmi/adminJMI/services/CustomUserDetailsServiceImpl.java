package com.mx.jmi.adminJMI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.Usuarios;
import com.mx.jmi.adminJMI.repository.UsuariosRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsuariosRepository usuariosRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = usuariosRepository.findByCorreo(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		 if (usuario == null) {
	            throw new UsernameNotFoundException("Could not find user with that email");
	     }
		 return new CustomUserDetailsImpl(usuario);
	}

}
