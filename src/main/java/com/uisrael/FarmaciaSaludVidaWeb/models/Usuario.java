package com.uisrael.FarmaciaSaludVidaWeb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "username", unique = true, length = 50, nullable = false)
	private String username;

	@Column(name = "password", unique = true, length = 50, nullable = false)
	private String password;

	@Column(name = "nombre_usuario", length = 50, nullable = false)
	private String nombreUsuario;

	@Column(name = "apellido_usuario", length = 50, nullable = false)
	private String apellidoUsuario;

	@Column(name = "rol", length = 50, nullable = false)
	private String rol;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	public Usuario() {
		
	}

	public Usuario(int idUsuario, String username, String password, String nombreUsuario, String apellidoUsuario,
			String rol, boolean estado) {
	
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.rol = rol;
		this.estado = estado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
