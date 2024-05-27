package com.macropay.msapp.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioRolId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2464129891839813815L;
	private Integer usuario;
	private Integer rol;

}
