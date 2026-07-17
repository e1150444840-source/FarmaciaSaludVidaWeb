package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class TipoClienteRequestDto {

	private final int idTipoCliente;
	private final String nombreTipoCliente; // VIP, Mayorista, persona natural
	private final String descripcion;
	private final boolean estado; // activo - eliminado
}
