package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

	// Comprobaciones para Creación
	boolean existsByNombreCategoria(String nombreCategoria);

	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByNombreCategoriaAndNombreCategoriaNot(String nombreCategoria, Integer idCategoria);
}
