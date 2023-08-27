package com.grupo16.techchallenge.endereco.gateway.repository.mysql;

import java.util.ArrayList;
import java.util.List;

import com.grupo16.techchallenge.endereco.dto.PesquisarEnderecoParamsDto;
import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.UsuarioEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoCriteriaBuilder {

	public static CriteriaQuery<EnderecoEntity> getSQLSearchCriteria(CriteriaBuilder cb, PesquisarEnderecoParamsDto paramsDto) {

    	CriteriaQuery<EnderecoEntity> criteriaQuery = cb.createQuery(EnderecoEntity.class);
    	Root<EnderecoEntity> rootEntity = criteriaQuery.from(EnderecoEntity.class);
    	
    	List<Predicate> predicates = new ArrayList<>();
    	
    	predicates.add(cb.equal(rootEntity.get("usuario"), UsuarioEntity.builder().id(paramsDto.getIdUsuario()).build()));

    	if(paramsDto.hasRua()) {
    		predicates.add(cb.like(rootEntity.get("rua"), "%" + paramsDto.getRua() + "%"));
    	}

    	if(paramsDto.hasBairro()) {
    		predicates.add(cb.like(rootEntity.get("bairro"), "%" + paramsDto.getBairro() + "%"));
    	}

    	if(paramsDto.hasCidade()) {
    		predicates.add(cb.like(rootEntity.get("cidade"), "%" + paramsDto.getCidade() + "%"));
    	}
    	
    	if(paramsDto.hasEstado()) {
    		predicates.add(cb.equal(rootEntity.get("estado"), paramsDto.getEstado().ordinal()));
    	}
    	
    	if(paramsDto.hasCep()) {
    		predicates.add(cb.like(rootEntity.get("cep"), "%" + paramsDto.getCep() + "%"));
    	}
    	

		final Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
		
		final Predicate finalPredicate = cb.and(predicatesArray);
		
		return criteriaQuery.where(finalPredicate);
	}
	
}
