package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.CategoriaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LaboratorioRequestDto;

public class ProductoResponseDto {

	private int idProducto;
	private String nombreProducto;
	private String descripcion;
	private CategoriaRequestDto fkCategoria;
	private LaboratorioRequestDto fkLaboratorio;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaRequestDto getFkCategoria() {
		return fkCategoria;
	}

	public void setFkCategoria(CategoriaRequestDto fkCategoria) {
		this.fkCategoria = fkCategoria;
	}

	public LaboratorioRequestDto getFkLaboratorio() {
		return fkLaboratorio;
	}

	public void setFkLaboratorio(LaboratorioRequestDto fkLaboratorio) {
		this.fkLaboratorio = fkLaboratorio;
	}

}
