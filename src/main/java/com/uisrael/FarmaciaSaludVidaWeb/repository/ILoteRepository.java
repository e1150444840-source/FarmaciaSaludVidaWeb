package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Lote;

public interface ILoteRepository extends JpaRepository<Lote, Integer>  {

	// Comprobaciones para Creación
	boolean existsByNumeroLote(String numeroLote);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByNumeroLoteAndNumeroLoteNot(String numeroLote, Integer idLote);

}
