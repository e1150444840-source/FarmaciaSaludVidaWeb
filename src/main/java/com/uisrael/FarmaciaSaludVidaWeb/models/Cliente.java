package com.uisrael.FarmaciaSaludVidaWeb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int idCliente;

	@Column(name = "ci", length = 13, unique = true, nullable = false)
	private String ciCliente;

	@Column(name = "nombre", length = 80, nullable = false)
	private String nombreCliente;

	@Column(name = "apellido", length = 80, nullable = false)
	private String apellidoCliente;

	@Column(name = "telefono", length = 80, unique = true, nullable = false)
	private String telefonoCliente;

	@Column(name = "direccion", length = 80, nullable = false)
	private String direccionCliente;

	@Column(name = "correo", length = 80, unique = true , nullable = false)
	private String correoCliente;

	public Cliente() {
	}
	
	public Cliente(int idCliente, String ciCliente, String nombreCliente, String apellidoCliente,
			String telefonoCliente, String direccionCliente, String correoCliente) {

		this.idCliente = idCliente;
		this.ciCliente = ciCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.telefonoCliente = telefonoCliente;
		this.direccionCliente = direccionCliente;
		this.correoCliente = correoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCiCliente() {
		return ciCliente;
	}

	public void setCiCliente(String ciCliente) {
		this.ciCliente = ciCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	
}
