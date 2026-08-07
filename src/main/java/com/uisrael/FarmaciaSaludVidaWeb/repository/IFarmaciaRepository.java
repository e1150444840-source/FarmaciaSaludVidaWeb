package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Farmacia;

public interface IFarmaciaRepository extends JpaRepository<Farmacia, Integer>{
	
	// Comprobaciones para Creación
	boolean existsByNombreFarmacia(String nombreFarmacia);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByNombreFarmaciaAndNombreFarmaciaNot(String nombreFarmacia, Integer idFarmacia);

}
