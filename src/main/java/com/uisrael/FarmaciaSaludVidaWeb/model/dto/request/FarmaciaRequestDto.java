package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class FarmaciaRequestDto {

	private final int idFarmacia;
	private final String nombreFarmacia;
	private final String direccion;
	private final String ciudad;
}
