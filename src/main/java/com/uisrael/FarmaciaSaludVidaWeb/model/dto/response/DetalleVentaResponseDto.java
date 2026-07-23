package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.InventarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VentaRequestDto;

public class DetalleVentaResponseDto {

	private int idDetalleVenta;
	private int cantidad;
	private double precioUnitario;
	private VentaRequestDto fkVenta;
	private InventarioRequestDto fkInventario;

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public VentaRequestDto getFkVenta() {
		return fkVenta;
	}

	public void setFkVenta(VentaRequestDto fkVenta) {
		this.fkVenta = fkVenta;
	}

	public InventarioRequestDto getFkInventario() {
		return fkInventario;
	}

	public void setFkInventario(InventarioRequestDto fkInventario) {
		this.fkInventario = fkInventario;
	}


}
