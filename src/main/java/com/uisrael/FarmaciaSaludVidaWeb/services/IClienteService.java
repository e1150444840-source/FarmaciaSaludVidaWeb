package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ClienteResponseDto;

public interface IClienteService {

	List<ClienteResponseDto> listarCliente();

	void guardarCliente(ClienteRequestDto nuevo);
	
	ClienteResponseDto buscarPorId(int idCliente);

}
