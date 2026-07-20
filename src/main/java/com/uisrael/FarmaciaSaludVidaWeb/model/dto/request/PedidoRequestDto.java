package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PedidoRequestDto {

	private int idPedido;
	private LocalDate fechaPedido;
	private String estadoPedido;
	private String direccionPedido;
	//private VentaEntity fkVenta;
	//private VehiculoEntity fkVehiculo;

}
