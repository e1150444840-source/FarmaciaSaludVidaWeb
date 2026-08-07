package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.TipoCliente;

public interface ITipoClienteRepository  extends JpaRepository<TipoCliente, Integer> {

	// Comprobaciones para Creación
	boolean existsByNombreTipoCliente(String nombreTipoCliente);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByNombreTipoClienteAndNombreTipoClienteNot(String nombreTipoCliente, Integer idTipoCliente);
}
