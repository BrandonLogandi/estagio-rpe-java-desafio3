package rpe.estagio.desafio3.service.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.presentation.dto.VeiculoDeCargaDTO;
import rpe.estagio.desafio3.template.DTOConverter;

@Service
public class VeiculoDeCargaConverter implements DTOConverter<VeiculoDeCarga, VeiculoDeCargaDTO> {

    @Override
    public VeiculoDeCargaDTO toDTO(VeiculoDeCarga entity) {
        return VeiculoDeCargaDTO.builder()
                .placa(entity.getPlaca())
                .nome(entity.getNome())
                .marca(entity.getMarca())
                .capacidade(entity.getCapacidade())
                .qtdCarroceria(entity.getQtdCarroceria())
                .build();
    }

    @Override
    public Iterable<VeiculoDeCargaDTO> toDTOIter(Iterable<VeiculoDeCarga> entityList) {
        List<VeiculoDeCargaDTO> list = new ArrayList<>();
        entityList.forEach(entity -> list.add(toDTO(entity)));

        return list;
    }

    @Override
    public VeiculoDeCarga toEntity(VeiculoDeCargaDTO dto) {
        return VeiculoDeCarga.builder()
                .placa(dto.getPlaca())
                .nome(dto.getNome())
                .marca(dto.getMarca())
                .capacidade(dto.getCapacidade())
                .qtdCarroceria(dto.getQtdCarroceria())
                .build();
    }

    @Override
    public Iterable<VeiculoDeCarga> toEntityIter(Iterable<VeiculoDeCargaDTO> dtoList) {
        List<VeiculoDeCarga> list = new ArrayList<>();
        dtoList.forEach(dto -> list.add(toEntity(dto)));
        return list;
    }

}
