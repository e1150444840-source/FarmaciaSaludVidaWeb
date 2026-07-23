package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.FarmaciaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LoteRequestDto;

public class InventarioResponseDto {

	private int idInventario;
	private int stockActual;
	private LoteRequestDto fkLote;
	private FarmaciaRequestDto fkFarmacia;

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public LoteRequestDto getFkLote() {
		return fkLote;
	}

	public void setFkLote(LoteRequestDto fkLote) {
		this.fkLote = fkLote;
	}

	public FarmaciaRequestDto getFkFarmacia() {
		return fkFarmacia;
	}

	public void setFkFarmacia(FarmaciaRequestDto fkFarmacia) {
		this.fkFarmacia = fkFarmacia;
	}

}
