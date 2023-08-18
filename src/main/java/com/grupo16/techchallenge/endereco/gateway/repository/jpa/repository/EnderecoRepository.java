package com.grupo16.techchallenge.endereco.gateway.repository.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

	List<EnderecoEntity> findByUsuarioId(Long idUsuario);

	Optional<EnderecoEntity> findByIdAndUsuarioId(Long id, Long idUsuario);

}
