package rpe.estagio.desafio3.model.repository;

import java.util.Optional;

import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;

public interface VeiculoDePasseioRepository extends VeiculoRepository {

    Optional<VeiculoDePasseio> findByNumPassageiros(int numPassageiros);

}
