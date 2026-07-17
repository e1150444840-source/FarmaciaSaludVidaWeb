package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class InventarioRequestDto {

	private final int idInventario;
	private final int stockActual;
	//private LoteEntity fkLote;
	//private FarmaciaEntity fkFarmacia;
}
