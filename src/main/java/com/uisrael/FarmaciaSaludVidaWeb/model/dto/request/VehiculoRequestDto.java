package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class VehiculoRequestDto {

	private final int idVehiculo;
	private final String placa;
	private final String capacidad;
	private final String estadoDisponibilidad;

}
