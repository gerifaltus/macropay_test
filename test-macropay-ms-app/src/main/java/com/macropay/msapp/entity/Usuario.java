package com.macropay.msapp.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario")
@Entity
public class Usuario implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8840386063490364823L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "celular", length = 15)
    private String celular;

	@ManyToMany(
			fetch = FetchType.EAGER
	)
    @JoinTable(
       name="tbl_usuario_rol",
       joinColumns=@JoinColumn(name="id_usuario"),
       inverseJoinColumns=@JoinColumn(name="id_rol")
    )
	private List<Rol> roles;	

}