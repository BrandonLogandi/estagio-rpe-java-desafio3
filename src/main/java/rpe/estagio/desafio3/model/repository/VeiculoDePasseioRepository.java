package rpe.estagio.desafio3.model.repository;

import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;

public interface VeiculoDePasseioRepository extends VeiculoRepository {

    Iterable<VeiculoDePasseio> findByNumPassageiros(int numPassageiros);

}
