package rpe.estagio.desafio3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;
import rpe.estagio.desafio3.model.repository.VeiculoRepository;
import rpe.estagio.desafio3.presentation.dto.VeiculoDePasseioDTO;

import rpe.estagio.desafio3.template.VeiculoServiceTemplate;

@Service
@SuppressWarnings("java:S112")
public class VeiculoDePasseioService implements VeiculoServiceTemplate<VeiculoDePasseio, VeiculoDePasseioDTO> {

    @Autowired
    private VeiculoRepository<VeiculoDePasseio> repository;

    @Override
    public VeiculoDePasseio create(VeiculoDePasseioDTO dto) throws Exception {
        if (repository.findByPlaca(dto.getPlaca()).isPresent())
            throw new Exception("Veiculo com mesma placa já existe: " + dto.getPlaca());

        VeiculoDePasseio v = VeiculoDePasseio.builder()
                .placa(dto.getPlaca())
                .nome(dto.getNome())
                .marca(dto.getMarca())
                .numPassageiros(dto.getNumPassageiros())
                .build();

        return repository.save(v);
    }

    @Override
    public VeiculoDePasseio findById(Long id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<VeiculoDePasseio> findByNome(String nome) throws NoSuchElementException {
        return this.castToList(repository.findByNome(nome));
    }

    @Override
    public List<VeiculoDePasseio> findByMarca(String marca) throws NoSuchElementException {
        return this.castToList(repository.findByMarca(marca));
    }

    @Override
    public VeiculoDePasseio findByPlaca(String placa) throws NoSuchElementException {
        return repository.findByPlaca(placa).orElseThrow();
    }

    @Override
    public List<VeiculoDePasseio> findAll() {
        return this.castToList(repository.findAll());
    }

    @Override
    public VeiculoDePasseio update(Long id, VeiculoDePasseioDTO dto) throws NoSuchElementException {
        VeiculoDePasseio result = this.findById(id);

        VeiculoDePasseio v = VeiculoDePasseio.builder()
                .placa(dto.getPlaca() != null ? dto.getPlaca() : result.getPlaca())
                .nome(dto.getNome() != null ? dto.getNome() : result.getNome())
                .marca(dto.getMarca() != null ? dto.getMarca() : result.getMarca())
                .numPassageiros(dto.getNumPassageiros() != 0 ? dto.getNumPassageiros() : result.getNumPassageiros())
                .build();

        return repository.save(v);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<VeiculoDePasseio> castToList(Iterable<VeiculoDePasseio> iterable) {
        List<VeiculoDePasseio> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

}
