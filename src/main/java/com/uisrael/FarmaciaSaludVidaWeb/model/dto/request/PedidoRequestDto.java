package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class PedidoRequestDto {

	private final int idPedido;
	private final String fechaPedido;
	private final String estadoPedido;
	private final String direccionPedido;
	//private VentaEntity fkVenta;
	//private VehiculoEntity fkVehiculo;

}
