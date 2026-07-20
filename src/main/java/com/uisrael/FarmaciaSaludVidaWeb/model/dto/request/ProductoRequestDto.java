package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class ProductoRequestDto {

	private int idProducto;
	private String nombreProducto;
	private String descripcion;
	//private CategoriaEntity fkCategoria;
	//private LaboratorioEntity fkLaboratorio;
}
