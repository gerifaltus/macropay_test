package com.macropay.msapp.service;

import java.util.Optional;

import com.macropay.msapp.entity.Usuario;

public interface UsuarioService {
    Optional<Usuario> getByUsername(String username);
}