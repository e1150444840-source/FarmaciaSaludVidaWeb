package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoteRequestDto {

	private final int idLote;
	private final String numeroLote;
	private final LocalDate fechaCaducidad;
	private final LocalDate fechaIngreso;
	// private ProductoEntity fkProducto;
}
