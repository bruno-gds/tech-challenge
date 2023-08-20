package com.grupo16.techchallenge.usuario.gateway.repository.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	Optional<UsuarioEntity> findByCpf(String cpf);



}
