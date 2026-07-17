package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class LaboratorioResponseDto {

	private int idLaboratorio;
	private String nombreLaboratorio;
	private String telefonoLaboratorio;

	public int getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}

	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

	public String getTelefonoLaboratorio() {
		return telefonoLaboratorio;
	}

	public void setTelefonoLaboratorio(String telefonoLaboratorio) {
		this.telefonoLaboratorio = telefonoLaboratorio;
	}

}
