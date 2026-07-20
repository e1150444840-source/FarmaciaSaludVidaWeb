package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class TipoClienteRequestDto {

	private int idTipoCliente;
	private String nombreTipoCliente; // VIP, Mayorista, persona natural
	private String descripcion;
	private boolean estado; // activo - eliminado
}
