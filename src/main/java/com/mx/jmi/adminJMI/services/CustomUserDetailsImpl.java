package com.mx.jmi.adminJMI.services;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mx.jmi.adminJMI.entity.Roles;
import com.mx.jmi.adminJMI.entity.Usuarios;

public class CustomUserDetailsImpl implements UserDetails  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String AVATAR_BY_DEFAULT = "/adminJMI/dist/img/generic_avatar.png";
	private Usuarios usuarios;
	
	public CustomUserDetailsImpl(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Roles> roles = usuarios.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Roles rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return authorities;
	}

	@Override
	public String getPassword() {
		return usuarios.getContrasena();
	}

	@Override
	public String getUsername() {
		return usuarios.getCorreo();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return usuarios.getEstatus() == 1 ? true : false;
	}
	
	public String getFullName() {
        return usuarios.getNombres() + " " + usuarios.getApellidos();
    }
	
	public String getAvatar() {
		String avatar = usuarios.getAvatar() != null && !usuarios.getAvatar().isEmpty() && !usuarios.getAvatar().isBlank() ? usuarios.getAvatar(): AVATAR_BY_DEFAULT;
        return avatar;
    }

}
