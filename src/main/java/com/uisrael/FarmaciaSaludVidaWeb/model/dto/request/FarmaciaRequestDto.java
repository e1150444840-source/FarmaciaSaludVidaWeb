package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class FarmaciaRequestDto {

	private int idFarmacia;
	private String nombreFarmacia;
	private String direccion;
	private String ciudad;
}
