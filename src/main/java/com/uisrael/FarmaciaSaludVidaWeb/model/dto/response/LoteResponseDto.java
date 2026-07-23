package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import java.time.LocalDate;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ProductoRequestDto;

public class LoteResponseDto {

	private int idLote;
	private String numeroLote;
	private LocalDate fechaCaducidad;
	private LocalDate fechaIngreso;
	private ProductoRequestDto fkProducto;

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public ProductoRequestDto getFkProducto() {
		return fkProducto;
	}

	public void setFkProducto(ProductoRequestDto fkProducto) {
		this.fkProducto = fkProducto;
	}

}
