package com.macropay.msapp.security.entity;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import com.macropay.msapp.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPrincipal implements UserDetails{
	

	private static final long serialVersionUID = -8361654238492971793L;
	
	private String nombre;
	private String nombreUsuario;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> roles;
	
	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> listAuthorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombreRol())).collect(Collectors.toList());
		return new UsuarioPrincipal(usuario.getNombre(), usuario.getUsername(), usuario.getUsername(), usuario.getPassword(), listAuthorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	
	@Override
	public String getUsername() {
		return nombreUsuario;
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
		return true;
	}

}
*/