package rpe.estagio.desafio3.service.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;
import rpe.estagio.desafio3.presentation.dto.VeiculoDePasseioDTO;
import rpe.estagio.desafio3.template.DTOConverter;

@Service
public class VeiculoDePasseioConverter implements DTOConverter<VeiculoDePasseio, VeiculoDePasseioDTO> {

    @Override
    public VeiculoDePasseioDTO toDTO(VeiculoDePasseio entity) {
        return VeiculoDePasseioDTO.builder()
                .placa(entity.getPlaca())
                .nome(entity.getNome())
                .marca(entity.getMarca())
                .numPassageiros(entity.getNumPassageiros())
                .build();
    }

    @Override
    public List<VeiculoDePasseioDTO> toDTOIter(Iterable<VeiculoDePasseio> entityList) {
        List<VeiculoDePasseioDTO> list = new ArrayList<>();
        entityList.forEach(entity -> list.add(toDTO(entity)));
        return list;
    }

    @Override
    public VeiculoDePasseio toEntity(VeiculoDePasseioDTO dto) {
        return VeiculoDePasseio.builder()
                .placa(dto.getPlaca())
                .nome(dto.getNome())
                .marca(dto.getMarca())
                .numPassageiros(dto.getNumPassageiros())
                .build();
    }

    @Override
    public List<VeiculoDePasseio> toEntityIter(Iterable<VeiculoDePasseioDTO> dtoList) {
        List<VeiculoDePasseio> list = new ArrayList<>();
        dtoList.forEach(dto -> list.add(toEntity(dto)));
        return list;
    }

}
