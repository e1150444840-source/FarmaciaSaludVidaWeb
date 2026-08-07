package com.uisrael.FarmaciaSaludVidaWeb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_laboratorio")
	private int idLaboratorio;

	@Column(name = "nombre_laboratorio", unique = true, length = 100, nullable = false)
	private String nombreLaboratorio;

	@Column(name = "telefono", unique = true, length = 10, nullable = false)
	private String telefonoLaboratorio;

	public Laboratorio() {
		
	}

	public Laboratorio(int idLaboratorio, String nombreLaboratorio, String telefonoLaboratorio) {
		
		this.idLaboratorio = idLaboratorio;
		this.nombreLaboratorio = nombreLaboratorio;
		this.telefonoLaboratorio = telefonoLaboratorio;
	}

	public int getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}

	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

	public String getTelefonoLaboratorio() {
		return telefonoLaboratorio;
	}

	public void setTelefonoLaboratorio(String telefonoLaboratorio) {
		this.telefonoLaboratorio = telefonoLaboratorio;
	}

}
