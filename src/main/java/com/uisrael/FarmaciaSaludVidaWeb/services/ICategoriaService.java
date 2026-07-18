package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.CategoriaResponseDto;
public interface ICategoriaService {

	List<CategoriaResponseDto> listarCategoria();
}
