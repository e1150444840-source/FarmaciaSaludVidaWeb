package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoteRequestDto {

	private int idLote;
	private String numeroLote;
	private LocalDate fechaCaducidad;
	private LocalDate fechaIngreso;
	private ProductoRequestDto fkProducto;
}
