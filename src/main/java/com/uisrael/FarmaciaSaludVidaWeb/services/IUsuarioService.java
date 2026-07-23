package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.UsuarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.UsuarioResponseDto;

public interface IUsuarioService {

	List<UsuarioResponseDto> listarUsuario();
	
	void guardarUsuario(UsuarioRequestDto nuevo);
	
	UsuarioResponseDto buscarPorId(int idUsuario);
}
