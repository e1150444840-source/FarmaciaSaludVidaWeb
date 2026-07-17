package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import lombok.Data;

@Data
public class TipoClienteResponseDto {

	private int idTipoCliente;
	private String nombreTipoCliente; // VIP, Mayorista, persona natural
	private String descripcion;
	private boolean estado; // activo - eliminado

}
