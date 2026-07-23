package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class DetalleVentaRequestDto {

	private int idDetalleVenta;
	private int cantidad;
	private double precioUnitario;
	private VentaRequestDto fkVenta;
	private InventarioRequestDto fkInventario;
}
