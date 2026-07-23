package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import java.time.LocalDate;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.UsuarioRequestDto;

public class VentaResponseDto {

	private int idVenta;
	private LocalDate fechaEmison;
	private String canalVenta; // Física', 'En Línea
	private double subtotal;
	private double iva;
	private double total;
	private ClienteRequestDto fkCliente;
	private UsuarioRequestDto fkUsuario;

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

	public ClienteRequestDto getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(ClienteRequestDto fkCliente) {
		this.fkCliente = fkCliente;
	}

	public UsuarioRequestDto getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(UsuarioRequestDto fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

}
