package rpe.estagio.desafio3.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.model.repository.VeiculoRepository;
import rpe.estagio.desafio3.presentation.dto.VeiculoDeCargaDTO;

import rpe.estagio.desafio3.template.VeiculoServiceTemplate;

@Service
@SuppressWarnings("java:S112")
public class VeiculoDeCargaService implements VeiculoServiceTemplate<VeiculoDeCarga, VeiculoDeCargaDTO> {

    @Autowired
    private VeiculoRepository<VeiculoDeCarga> repository;

    @Override
    public VeiculoDeCarga create(VeiculoDeCargaDTO dto) throws Exception {
        if (repository.findByPlaca(dto.getPlaca()).isPresent())
            throw new Exception("Veiculo com mesma placa já existe: " + dto.getPlaca());

        VeiculoDeCarga v = VeiculoDeCarga.builder()
                .placa(dto.getPlaca())
                .nome(dto.getNome())
                .marca(dto.getMarca())
                .capacidade(dto.getCapacidade())
                .qtdCarroceria(dto.getQtdCarroceria())
                .build();

        return repository.save(v);
    }

    @Override
    public VeiculoDeCarga findById(Long id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public VeiculoDeCarga findByPlaca(String placa) throws NoSuchElementException {
        return repository.findByPlaca(placa).orElseThrow();
    }

    @Override
    public Iterable<VeiculoDeCarga> findByNome(String nome) throws NoSuchElementException {
        return repository.findByNome(nome);
    }

    @Override
    public Iterable<VeiculoDeCarga> findByMarca(String marca) throws NoSuchElementException {
        return repository.findByMarca(marca);
    }

    @Override
    public Iterable<VeiculoDeCarga> findAll() {
        return repository.findAll();
    }

    @Override
    public VeiculoDeCarga update(Long id, VeiculoDeCargaDTO dto) throws NoSuchElementException {
        VeiculoDeCarga result = this.findById(id);

        VeiculoDeCarga v = VeiculoDeCarga.builder()
                .id(result.getId())
                .placa(dto.getPlaca() != null ? dto.getPlaca() : result.getPlaca())
                .nome(dto.getNome() != null ? dto.getNome() : result.getNome())
                .marca(dto.getMarca() != null ? dto.getMarca() : result.getMarca())
                .capacidade(dto.getCapacidade() != 0 ? dto.getCapacidade() : result.getCapacidade())
                .qtdCarroceria(dto.getQtdCarroceria() != 0 ? dto.getQtdCarroceria() : result.getQtdCarroceria())
                .build();

        return repository.save(v);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
