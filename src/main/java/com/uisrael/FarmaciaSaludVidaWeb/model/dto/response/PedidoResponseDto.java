package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class PedidoResponseDto {

	private int idPedido;
	private String fechaPedido;
	private String estadoPedido;
	private String direccionPedido;
	//private VentaEntity fkVenta;
	//private VehiculoEntity fkVehiculo;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
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

	/*public VentaEntity getFkVenta() {
		return fkVenta;
	}

	public void setFkVenta(VentaEntity fkVenta) {
		this.fkVenta = fkVenta;
	}

	public VehiculoEntity getFkVehiculo() {
		return fkVehiculo;
	}

	public void setFkVehiculo(VehiculoEntity fkVehiculo) {
		this.fkVehiculo = fkVehiculo;
	}*/

}
