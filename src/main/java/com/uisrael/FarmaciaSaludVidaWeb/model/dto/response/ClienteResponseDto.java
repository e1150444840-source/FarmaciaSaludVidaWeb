package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.TipoClienteRequestDto;

import lombok.Data;

@Data
public class ClienteResponseDto {

	private int idCliente;
	private String ciCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String telefonoCliente;
	private String direccionCliente;
	private String correoCliente;
	private TipoClienteRequestDto fkTipoCliente;

}
