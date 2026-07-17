package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDto {

	private final int idCliente;// porque trabaja el FJPA
	
	private final String ciCliente;

	private final String nombreCliente;

	private final String apellidoCliente;

	private final String telefonoCliente;

	private final String direccionCliente;

	private final String correoCliente;

	//private TipoClienteEntity fkTipoCliente;
}
