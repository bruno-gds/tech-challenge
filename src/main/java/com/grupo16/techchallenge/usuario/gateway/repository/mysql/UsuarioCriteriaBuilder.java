package com.grupo16.techchallenge.usuario.gateway.repository.mysql;

import java.util.ArrayList;
import java.util.List;

import com.grupo16.techchallenge.usuario.dto.PesquisarUsuarioParamsDto;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.UsuarioEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioCriteriaBuilder {

	public static CriteriaQuery<UsuarioEntity> getSQLSearchCriteria(CriteriaBuilder cb, PesquisarUsuarioParamsDto paramsDto) {

    	CriteriaQuery<UsuarioEntity> criteriaQuery = cb.createQuery(UsuarioEntity.class);
    	Root<UsuarioEntity> rootEntity = criteriaQuery.from(UsuarioEntity.class);
    	
    	List<Predicate> predicates = new ArrayList<>();
    	
    	predicates.add(cb.equal(rootEntity.get("parenteId"), paramsDto.getIdUsuarioPrincipal()));

    	if(paramsDto.hasNome()) {
    		predicates.add(cb.like(rootEntity.get("nome"), "%" + paramsDto.getNome() + "%"));
    	}

    	if(paramsDto.hasCpf()) {
    		predicates.add(cb.like(rootEntity.get("cpf"), "%" + paramsDto.getCpf() + "%"));
    	}

    	if(paramsDto.hasParentesco()) {
    		predicates.add(cb.equal(rootEntity.get("tipoParentesco"), paramsDto.getParentesco().ordinal()));
    	}
    	
    	if(paramsDto.hasGenero()) {
    		predicates.add(cb.equal(rootEntity.get("genero"), paramsDto.getGenero().ordinal()));
    	}
    	
    	if(paramsDto.hasDataNascimento()) {
    		predicates.add(cb.equal(rootEntity.get("dataNascimento"), paramsDto.getDataNascimento()));
    	}
    	

		final Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
		
		final Predicate finalPredicate = cb.and(predicatesArray);
		
		return criteriaQuery.where(finalPredicate);
	}
	
}
