package com.uisrael.FarmaciaSaludVidaWeb.model.dto.response;

public class InventarioResponseDto {

	private int idInventario;
	private int stockActual;
	//private LoteEntity fkLote;
	//private FarmaciaEntity fkFarmacia;

	/*public FarmaciaEntity getFkFarmacia() {
		return fkFarmacia;
	}

	public void setFkFarmacia(FarmaciaEntity fkFarmacia) {
		this.fkFarmacia = fkFarmacia;
	}*/

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

	/*public LoteEntity getFkLote() {
		return fkLote;
	}

	public void setFkLote(LoteEntity fkLote) {
		this.fkLote = fkLote;
	}*/

}
