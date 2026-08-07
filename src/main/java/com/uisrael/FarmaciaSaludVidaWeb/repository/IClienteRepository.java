package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	// Comprobaciones para Creación
	boolean existsByCiCliente(String ciCliente);

	boolean existsByCorreoCliente(String correoCliente);

	boolean existsByTelefonoCliente(String telefonoCliente);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByCiClienteAndIdClienteNot(String ciCliente, Integer idCliente);

	boolean existsByCorreoClienteAndIdClienteNot(String correoCliente, Integer idCliente);

	boolean existsByTelefonoClienteAndIdClienteNot(String telefonoCliente, Integer idCliente);
}
