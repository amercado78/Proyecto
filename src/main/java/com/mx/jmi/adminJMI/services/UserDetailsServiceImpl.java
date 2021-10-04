package com.mx.jmi.adminJMI.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.Usuarios;
import com.mx.jmi.adminJMI.repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UsuariosRepository usuariosRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuario = usuariosRepository.findByCorreo(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();		
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getRol().getNombre());
		grantList.add(grantedAuthority);		
		UserDetails user = (UserDetails) new User(usuario.getCorreo(), usuario.getContrasena(), grantList);
				
		return user;
	}

}
