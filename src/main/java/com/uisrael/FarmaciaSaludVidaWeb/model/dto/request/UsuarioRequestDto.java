package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class UsuarioRequestDto {

	private int idUsuario;
	private String username;
	private String password;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String rol;
	private boolean estado; // activo - eliminado
}
