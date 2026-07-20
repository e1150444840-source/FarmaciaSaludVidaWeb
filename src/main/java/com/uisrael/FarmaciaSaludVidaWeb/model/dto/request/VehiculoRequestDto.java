package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class VehiculoRequestDto {

	private int idVehiculo;
	private String placa;
	private String capacidad;
	private  String estadoDisponibilidad;

}
