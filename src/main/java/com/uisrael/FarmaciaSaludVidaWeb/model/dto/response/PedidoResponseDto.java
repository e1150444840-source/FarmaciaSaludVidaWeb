package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import java.time.LocalDate;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VehiculoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VentaRequestDto;

public class PedidoResponseDto {

	private int idPedido;
	private LocalDate fechaPedido;
	private String estadoPedido;
	private String direccionPedido;
	private VentaRequestDto fkVenta;
	private VehiculoRequestDto fkVehiculo;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public String getDireccionPedido() {
		return direccionPedido;
	}

	public void setDireccionPedido(String direccionPedido) {
		this.direccionPedido = direccionPedido;
	}

	public VentaRequestDto getFkVenta() {
		return fkVenta;
	}

	public void setFkVenta(VentaRequestDto fkVenta) {
		this.fkVenta = fkVenta;
	}

	public VehiculoRequestDto getFkVehiculo() {
		return fkVehiculo;
	}

	public void setFkVehiculo(VehiculoRequestDto fkVehiculo) {
		this.fkVehiculo = fkVehiculo;
	}
}
