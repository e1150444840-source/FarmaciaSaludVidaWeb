package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class ProductoRequestDto {

	private final int idProducto;
	private final String nombreProducto;
	private final String descripcion;
	//private CategoriaEntity fkCategoria;
	//private LaboratorioEntity fkLaboratorio;
}
