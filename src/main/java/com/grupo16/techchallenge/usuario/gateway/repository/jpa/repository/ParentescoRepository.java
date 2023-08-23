package com.grupo16.techchallenge.usuario.gateway.repository.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.ParentescoEntity;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.ParentescoId;

public interface ParentescoRepository extends JpaRepository<ParentescoEntity, ParentescoId> {


}
