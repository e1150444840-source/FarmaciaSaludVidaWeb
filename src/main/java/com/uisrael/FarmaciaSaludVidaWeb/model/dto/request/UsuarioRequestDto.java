package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class UsuarioRequestDto {

	private final int idUsuario;
	private final String username;
	private final String password;
	private final String nombreUsuario;
	private final String apellidoUsuario;
	private final String rol;
	private final boolean estado; // activo - eliminado
}
