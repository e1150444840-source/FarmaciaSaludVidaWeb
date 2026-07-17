package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class VehiculoResponseDto {

	private int idVehiculo;
	private String placa;
	private String capacidad;
	private String estadoDisponibilidad;

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
