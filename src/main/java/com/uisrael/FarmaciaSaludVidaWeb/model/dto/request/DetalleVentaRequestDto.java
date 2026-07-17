package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class DetalleVentaRequestDto {

	private final int idDetalleVenta;
	private final int cantidad;
	private final double precioUnitario;
	// private VentaEntity fkVenta;
	// private InventarioEntity fkInventario;
}
