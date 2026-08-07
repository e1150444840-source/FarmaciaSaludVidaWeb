package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Vehiculo;

public interface IvehiculoRepository extends JpaRepository<Vehiculo, Integer>  {

	// Comprobaciones para Creación
	boolean existsByPlaca(String placa);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByPlacaAndPlacaNot(String placa, Integer idVehiculo);
}
