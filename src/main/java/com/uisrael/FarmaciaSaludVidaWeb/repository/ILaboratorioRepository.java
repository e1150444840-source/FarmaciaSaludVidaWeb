package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Laboratorio;

public interface ILaboratorioRepository extends JpaRepository<Laboratorio, Integer> {

	// Comprobaciones para Creación
	boolean existsByNombreLaboratorio(String nombreLaboratorio);

	boolean existsByTelefonoLaboratorio(String telefonoLaboratorio);
	
	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByNombreLaboratorioAndNombreLaboratorioNot(String nombreLaboratorio, Integer idLaboratorio);

	boolean existsByTelefonoLaboratorioAndTelefonoLaboratorioNot(String telefonoLaboratorio, Integer idLaboratorio);

}
