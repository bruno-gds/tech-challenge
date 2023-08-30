package com.grupo16.techchallenge.eletrodomestico.gateway.repository.mysql;

import com.grupo16.techchallenge.eletrodomestico.controller.json.EletrodomesticoJson;
import com.grupo16.techchallenge.eletrodomestico.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.EletrodomesticoEntity;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository.EletrodomesticoRepository;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/08/2023
 * Project Name: tech-challenge
 */

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
    public Optional<Eletrodomestico> obterIdEIdEndereco(Long id, Long enderecoId) {
        try {
            log.trace("Start eletrodomesticoId={}, enderecoId={}", id, enderecoId);

            Optional<EletrodomesticoEntity> entityOp = eletrodomesticoRepository.findByIdAndEnderecoId(id, enderecoId);
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
    public Page<Eletrodomestico> obterTodos(PageRequest pageRequest) {
        try {
            log.trace("Start pageRequest={}", pageRequest);

            var entity = eletrodomesticoRepository.findAll(pageRequest);

            log.trace("End eletrodomesticos={}", entity);
            return entity.map(EletrodomesticoEntity::mapToDomain);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }

    @Override
    public List<Eletrodomestico> buscaFiltrada(String nome, String modelo, String marca, Long potencia) {
        try {
            log.trace("Start nome={}, modelo={}, marca={}, potencia={}", nome, modelo, marca, potencia);

            var entity = eletrodomesticoRepository.buscaFiltrada(nome, modelo, marca, potencia);
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
