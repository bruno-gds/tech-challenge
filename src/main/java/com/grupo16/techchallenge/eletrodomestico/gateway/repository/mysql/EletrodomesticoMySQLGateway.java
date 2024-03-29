package com.grupo16.techchallenge.eletrodomestico.gateway.repository.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.gateway.exception.ErroAoExcluirEletrodomesticoException;
import com.grupo16.techchallenge.eletrodomestico.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.EletrodomesticoEntity;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository.EletrodomesticoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EletrodomesticoMySQLGateway implements EletrodomesticoRepositoryGateway {

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    @Override
    public Long criar(Eletrodomestico eletrodomestico) {
        try {
            log.trace("Start eletrodomestico={}", eletrodomestico);

            EletrodomesticoEntity eletrodomesticoEntity = new EletrodomesticoEntity(eletrodomestico);

            eletrodomesticoRepository.save(eletrodomesticoEntity);

            log.trace("End id={}", eletrodomesticoEntity.getId());
            return eletrodomesticoEntity.getId();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }

    @Override
    public Optional<Eletrodomestico> obterIdAndUsuarioId(Long id, Long usuarioId) {
        try {
            log.trace("Start eletrodomesticoId={}, usuarioId={}", id, usuarioId);

            Optional<EletrodomesticoEntity> entityOp = eletrodomesticoRepository.findByIdAndEnderecoUsuarioId(id, usuarioId);
            Optional<Eletrodomestico> eletrodomesticoOp = checarSeEntityExisteMapearParaDomain(entityOp);

            log.trace("End eletrodomesticoOp={}", eletrodomesticoOp);
            return eletrodomesticoOp;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }

    @Override
    public Optional<Eletrodomestico> obter(Long id) {
        try {
            log.trace("Start id={}", id);

            Optional<EletrodomesticoEntity> entityOp = eletrodomesticoRepository.findById(id);
            Optional<Eletrodomestico> eletrodomesticoOp = checarSeEntityExisteMapearParaDomain(entityOp);

            log.trace("End eletrodomesticoOp={}", eletrodomesticoOp);
            return eletrodomesticoOp;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }

    @Override
    public List<Eletrodomestico> buscaFiltrada(Long idUsuario, String nome, String modelo, String marca, Long potencia) {
        try {
            log.trace("Start idUsuario={}, nome={}, modelo={}, marca={}, potencia={}", idUsuario, nome, modelo, marca, potencia);

            var entity = eletrodomesticoRepository.buscaFiltrada(idUsuario, nome, modelo, marca, potencia);
            List<Eletrodomestico> domain = entity.stream().map(EletrodomesticoEntity::mapToDomain).toList();

            log.trace("End eletrodomesticoOp={}", domain);
            return domain;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            log.trace("Start id={}", id);

            eletrodomesticoRepository.deleteById(id);

            log.trace("End");
		} catch (DataIntegrityViolationException e) {
			log.error(e.getMessage(), e);
			throw new ErroAoExcluirEletrodomesticoException();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }

    private Optional<Eletrodomestico> checarSeEntityExisteMapearParaDomain(Optional<EletrodomesticoEntity> entityOp){
        Optional<Eletrodomestico> eletrodomesticoOp = Optional.empty();
        if(entityOp.isEmpty()) {
            return eletrodomesticoOp;
        }
        Eletrodomestico eletrodomestico = entityOp.get().mapToDomain();
        return Optional.of(eletrodomestico);
    }
}
