package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDto {

	private int idCliente;// porque trabaja el FJPA
	
	private String ciCliente;

	private String nombreCliente;

	private String apellidoCliente;

	private String telefonoCliente;

	private String direccionCliente;

	private String correoCliente;

	//private TipoClienteEntity fkTipoCliente;
}
