package com.uisrael.FarmaciaSaludVidaWeb.model.dto.request;

import lombok.Data;

@Data
public class LaboratorioRequestDto {

	private final int idLaboratorio;
	private final String nombreLaboratorio;
	private final String telefonoLaboratorio;
}
