package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class InventarioRequestDto {

	private int idInventario;
	private int stockActual;
	//private LoteEntity fkLote;
	//private FarmaciaEntity fkFarmacia;
}
