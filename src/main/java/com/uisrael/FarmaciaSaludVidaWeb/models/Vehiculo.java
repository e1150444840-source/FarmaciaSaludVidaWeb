package com.uisrael.FarmaciaSaludVidaWeb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehiculo")
	private int idVehiculo;
	
	@Column(name = "placa", unique = true, length = 10, nullable = false)
	private String placa; 
	
	@Column(name = "capacidad", length = 50, nullable = false)
	private String capacidad;
	
	@Column(name = "estado_disponibilidad", length = 20, nullable = false)
	private String estadoDisponibilidad;

	public Vehiculo(int idVehiculo, String placa, String capacidad, String estadoDisponibilidad) {
		
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.capacidad = capacidad;
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	public Vehiculo() {
		
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}

	public void setEstadoDisponibilidad(String estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}
	
	
}
