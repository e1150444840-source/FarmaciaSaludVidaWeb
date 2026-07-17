package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import java.time.LocalDate;

public class VentaResponseDto {

	private int idVenta;
	private LocalDate fechaEmison;
	private String canalVenta; // Física', 'En Línea
	private double subtotal;
	private double iva;
	private double total;
	//private ClienteEntity fkCliente;
	//private UsuarioEntity fkUsuario;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDate getFechaEmison() {
		return fechaEmison;
	}

	public void setFechaEmison(LocalDate fechaEmison) {
		this.fechaEmison = fechaEmison;
	}

	public String getCanalVenta() {
		return canalVenta;
	}

	public void setCanalVenta(String canalVenta) {
		this.canalVenta = canalVenta;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/*public ClienteEntity getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(ClienteEntity fkCliente) {
		this.fkCliente = fkCliente;
	}

	public UsuarioEntity getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(UsuarioEntity fkUsuario) {
		this.fkUsuario = fkUsuario;
	}*/

}
