package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class ProductoResponseDto {

	private int idProducto;
	private String nombreProducto;
	private String descripcion;
	//private CategoriaEntity fkCategoria;
	//private LaboratorioEntity fkLaboratorio;

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

	/*public CategoriaEntity getFkCategoria() {
		return fkCategoria;
	}

	public void setFkCategoria(CategoriaEntity fkCategoria) {
		this.fkCategoria = fkCategoria;
	}

	public LaboratorioEntity getFkLaboratorio() {
		return fkLaboratorio;
	}

	public void setFkLaboratorio(LaboratorioEntity fkLaboratorio) {
		this.fkLaboratorio = fkLaboratorio;
	}*/

}
