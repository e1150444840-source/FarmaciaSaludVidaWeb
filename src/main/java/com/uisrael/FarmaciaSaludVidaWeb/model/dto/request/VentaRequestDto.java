package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VentaRequestDto {

	private int idVenta;
	private LocalDate fechaEmison;
	private String canalVenta; // Física', 'En Línea
	private double subtotal;
	private double iva;
	private double total;
	// private ClienteEntity fkCliente;
	// private UsuarioEntity fkUsuario;
}
