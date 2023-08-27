package com.grupo16.techchallenge.endereco.gateway.repository.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.dto.PesquisarEnderecoParamsDto;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;
import com.grupo16.techchallenge.endereco.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;
import com.grupo16.techchallenge.endereco.gateway.repository.jpa.repository.EnderecoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EnderecoMySQLGateway implements EnderecoRepositoryGateway {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Long salvar(Endereco endereco) {		
		try {
			log.trace("Start endereco={}", endereco);
			
			EnderecoEntity entity = new EnderecoEntity(endereco);
			
			enderecoRepository.save(entity);
			
			log.trace("End id={}", entity.getId());
			return entity.getId();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}

	@Override
	public Optional<Endereco> obterByIdAndUsuarioId(Long id, Long usuarioId) {
		try {
			log.trace("Start enderecoId={}, usuarioId={}", id, usuarioId);
			
			Optional<EnderecoEntity> entityOp = enderecoRepository.findByIdAndUsuarioId(id, usuarioId);		
			Optional<Endereco> enderecoOp = checarSeEntityExisteMapearParaDomain(entityOp);
			
			log.trace("End enderecoOp={}", enderecoOp);
			return enderecoOp;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}
	
	@Override
	public Optional<Endereco> obter(Long id) {
		try {
			log.trace("Start id={}", id);
			
			Optional<EnderecoEntity> entityOp = enderecoRepository.findById(id);
			Optional<Endereco> enderecoOp = checarSeEntityExisteMapearParaDomain(entityOp);
			
			log.trace("End enderecoOp={}", enderecoOp);
			return enderecoOp;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}
	
	@Override
	public void remover(Long id) {
		try {
			log.trace("Start id={}", id);
			
			enderecoRepository.deleteById(id);
			
			log.trace("End");
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}

	@Override
	public List<Endereco> pesquisar(PesquisarEnderecoParamsDto paramsDto) {
		try {
			log.trace("Start paramsDto={}", paramsDto);
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<EnderecoEntity> criteria = EnderecoCriteriaBuilder.getSQLSearchCriteria(cb, paramsDto);
			
			TypedQuery<EnderecoEntity> query = entityManager.createQuery(criteria);
			
			List<EnderecoEntity> entities = query.getResultList();
			
			List<Endereco> domains = entities.stream().map(EnderecoEntity::mapToDomain).toList();
			
			log.trace("End domains={}", domains);

			return domains;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}

	
	private Optional<Endereco> checarSeEntityExisteMapearParaDomain(Optional<EnderecoEntity> entityOp){
		Optional<Endereco> enderecoOp = Optional.empty();
		if(entityOp.isEmpty()) {
			return enderecoOp; 
		}
		enderecoOp = Optional.of(entityOp.get().mapToDomain());
		
		return enderecoOp;
	}

}
