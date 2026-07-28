package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ProductoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ProductoResponseDto;


public interface IProductoService {

	List<ProductoResponseDto> listarProducto();

	void guardarProducto(ProductoRequestDto nuevo);
	
	ProductoResponseDto buscarPorId(int idProducto);
	
	ProductoResponseDto eliminarPorId(int idProducto);
}
