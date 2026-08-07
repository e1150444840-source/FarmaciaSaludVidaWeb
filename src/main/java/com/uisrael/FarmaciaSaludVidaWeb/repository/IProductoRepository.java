package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

	// Comprobaciones para Creación
	boolean existsByNombreProducto(String nombreProducto);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByNombreProductoAndNombreProductoNot(String nombreProducto, Integer idProducto);
}
