package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.TipoClienteResponseDto;

public interface ITipoClienteService {

	List<TipoClienteResponseDto> listarTipoCliente();
}
