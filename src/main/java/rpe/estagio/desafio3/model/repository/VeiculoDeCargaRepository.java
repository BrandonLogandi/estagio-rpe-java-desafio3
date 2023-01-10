package rpe.estagio.desafio3.model.repository;

import java.util.Optional;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;

public interface VeiculoDeCargaRepository extends VeiculoRepository {

    Optional<VeiculoDeCarga> findByCapacidade(int capacidade);
    Optional<VeiculoDeCarga> findByQtdCarroceria(int qtdCarroceria);
    
}
