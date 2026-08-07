package com.uisrael.FarmaciaSaludVidaWeb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_cliente")
public class TipoCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_tipo_cliente")
	private int idTipoCliente;

	@Column(name = "nombre_tipo_cliente", unique = true, length = 80, nullable = false)
	private String nombreTipoCliente;

	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	public TipoCliente() {
		
	}

	public TipoCliente(int idTipoCliente, String nombreTipoCliente, String descripcion, boolean estado) {
		
		this.idTipoCliente = idTipoCliente;
		this.nombreTipoCliente = nombreTipoCliente;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getNombreTipoCliente() {
		return nombreTipoCliente;
	}

	public void setNombreTipoCliente(String nombreTipoCliente) {
		this.nombreTipoCliente = nombreTipoCliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
