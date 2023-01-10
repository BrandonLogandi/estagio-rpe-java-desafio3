package rpe.estagio.desafio3.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import rpe.estagio.desafio3.model.entity.Veiculo;

@NoRepositoryBean
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

    Optional<Veiculo> findByPlaca(String placa);

    Optional<Veiculo> findByNome(String nome);

    Optional<Veiculo> findByMarca(String marca);

}
