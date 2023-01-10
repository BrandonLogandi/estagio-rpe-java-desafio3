package rpe.estagio.desafio3.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import rpe.estagio.desafio3.model.entity.Veiculo;

@NoRepositoryBean
public interface VeiculoRepository<T extends Veiculo> extends CrudRepository<T, Long> {

    Optional<T> findByPlaca(String placa);

    Iterable<T> findByNome(String nome);

    Iterable<T> findByMarca(String marca);

}
