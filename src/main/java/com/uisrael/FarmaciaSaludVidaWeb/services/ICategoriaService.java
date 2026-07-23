package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.CategoriaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.CategoriaResponseDto;
public interface ICategoriaService {

	List<CategoriaResponseDto> listarCategoria();

	void guardarCategoria(CategoriaRequestDto nuevo);
	
	CategoriaResponseDto buscarPorId(int idCategoria);
}
