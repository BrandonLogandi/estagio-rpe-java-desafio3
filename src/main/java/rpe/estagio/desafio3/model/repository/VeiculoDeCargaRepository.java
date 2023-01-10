package rpe.estagio.desafio3.model.repository;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;

public interface VeiculoDeCargaRepository extends VeiculoRepository {

    Iterable<VeiculoDeCarga> findByCapacidade(int capacidade);
    Iterable<VeiculoDeCarga> findByQtdCarroceria(int qtdCarroceria);
    
}
