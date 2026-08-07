package com.uisrael.FarmaciaSaludVidaWeb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmacia")
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_farmacia")
	private int idFarmacia;

	@Column(name = "nombre_farmacia", unique = true, length = 100, nullable = false)
	private String nombreFarmacia;

	@Column(name = "direccion", length = 100, nullable = false)
	private String direccion;

	@Column(name = "ciudad", length = 100, nullable = false)
	private String ciudad;

	public Farmacia() {
		
	}

	public Farmacia(int idFarmacia, String nombreFarmacia, String direccion, String ciudad) {
		
		this.idFarmacia = idFarmacia;
		this.nombreFarmacia = nombreFarmacia;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}

	public int getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(int idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public String getNombreFarmacia() {
		return nombreFarmacia;
	}

	public void setNombreFarmacia(String nombreFarmacia) {
		this.nombreFarmacia = nombreFarmacia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
