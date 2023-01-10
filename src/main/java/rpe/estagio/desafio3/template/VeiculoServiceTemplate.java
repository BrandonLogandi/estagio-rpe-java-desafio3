package rpe.estagio.desafio3.template;

import java.util.NoSuchElementException;

import rpe.estagio.desafio3.model.entity.Veiculo;
import rpe.estagio.desafio3.presentation.dto.VeiculoDTO;

@SuppressWarnings("java:S112")
public interface VeiculoServiceTemplate<T extends Veiculo, D extends VeiculoDTO> {

    public T create(D dto) throws Exception;

    public T findById(Long id) throws NoSuchElementException;

    public T findByPlaca(String placa) throws NoSuchElementException;

    public Iterable<T> findByNome(String nome) throws NoSuchElementException;

    public Iterable<T> findByMarca(String marca) throws NoSuchElementException;

    public Iterable<T> findAll();

    public T update(Long id, D dto) throws NoSuchElementException;

    public void delete(Long id);

}
