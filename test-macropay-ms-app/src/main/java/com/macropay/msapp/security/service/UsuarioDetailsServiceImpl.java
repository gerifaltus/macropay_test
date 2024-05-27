package com.macropay.msapp.security.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
*/
import org.springframework.stereotype.Service;

import com.macropay.msapp.entity.Usuario;
import com.macropay.msapp.service.UsuarioService;

@Service
@Qualifier("UsuarioDetailsService")
public class UsuarioDetailsServiceImpl  {

    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    */
/*
	private UsuarioService usuarioService;

	public UsuarioDetailsServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = this.usuarioService.getByUsername(username)
       .orElseThrow(() -> new UsernameNotFoundException("Email " + username + " no encontrado"));
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(),
        getAuthorities(usuario));
	}
	
    private static Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        String[] userRoles = usuario.getRoles().stream().map(role -> role.getNombreRol()).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }
  */ 
}
