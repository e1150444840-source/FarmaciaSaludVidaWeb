package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VentaRequestDto {

	private final int idVenta;
	private final LocalDate fechaEmison;
	private final String canalVenta; // Física', 'En Línea
	private final double subtotal;
	private final double iva;
	private final double total;
	// private ClienteEntity fkCliente;
	// private UsuarioEntity fkUsuario;
}
