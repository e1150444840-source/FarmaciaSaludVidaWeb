package com.uisrael.FarmaciaSaludVidaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.FarmaciaSaludVidaWeb.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	// Comprobaciones para Creación
	boolean existsByPassword(String password);

	boolean existsByUsername(String username);
	
	// Comprobaciones para Edición (excluyen el ID actual)
	boolean existsByPasswordAndPasswordNot(String password, Integer idUsuario);

	boolean existsByUsernameAndUsernameNot(String username, Integer idUsuario);

}
