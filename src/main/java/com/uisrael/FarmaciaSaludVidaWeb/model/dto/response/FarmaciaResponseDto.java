package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class FarmaciaResponseDto {

	private int idFarmacia;
	private String nombreFarmacia;
	private String direccion;
	private String ciudad;

	public int getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(int idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public String getNombreFarmacia() {
		return nombreFarmacia;
	}

	public void setNombreFarmacia(String nombreFarmacia) {
		this.nombreFarmacia = nombreFarmacia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
