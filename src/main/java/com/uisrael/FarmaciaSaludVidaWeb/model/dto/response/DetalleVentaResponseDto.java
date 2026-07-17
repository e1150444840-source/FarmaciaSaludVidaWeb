package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class DetalleVentaResponseDto {

	private int idDetalleVenta;
	private int cantidad;
	private double precioUnitario;
	//private VentaEntity fkVenta;
	//private InventarioEntity fkInventario;

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

	/*public VentaEntity getFkVenta() {
		return fkVenta;
	}

	public void setFkVenta(VentaEntity fkVenta) {
		this.fkVenta = fkVenta;
	}

	public InventarioEntity getFkInventario() {
		return fkInventario;
	}

	public void setFkInventario(InventarioEntity fkInventario) {
		this.fkInventario = fkInventario;
	}*/

}
