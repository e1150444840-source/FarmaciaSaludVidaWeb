package com.uisrael.FarmaciaSaludVidaWeb.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lote")
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lote")
	private int idLote;

	@Column(name = "numero_lote", unique = true, length = 50, nullable = false)
	private String numeroLote;

	@Column(name = "fecha_caducidad", nullable = false)
	private LocalDate fechaCaducidad;

	@Column(name = "fecha_ingreso", nullable = false)
	private LocalDate fechaIngreso;

	public Lote() {

	}

	public Lote(int idLote, String numeroLote, LocalDate fechaCaducidad, LocalDate fechaIngreso) {

		this.idLote = idLote;
		this.numeroLote = numeroLote;
		this.fechaCaducidad = fechaCaducidad;
		this.fechaIngreso = fechaIngreso;
	}

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

}
