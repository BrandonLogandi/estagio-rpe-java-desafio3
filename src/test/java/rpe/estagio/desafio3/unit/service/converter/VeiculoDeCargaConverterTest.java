package rpe.estagio.desafio3.unit.service.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.presentation.dto.VeiculoDeCargaDTO;
import rpe.estagio.desafio3.service.converter.VeiculoDeCargaConverter;
import rpe.estagio.desafio3.template.DTOConverter;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class VeiculoDeCargaConverterTest {

    private DTOConverter<VeiculoDeCarga, VeiculoDeCargaDTO> converter;
    private List<VeiculoDeCarga> entities;
    private List<VeiculoDeCargaDTO> dtos;

    @BeforeAll
    void setUp() {
        converter = new VeiculoDeCargaConverter();
        entities = new ArrayList<>();
        dtos = new ArrayList<>();

        entities.add(VeiculoDeCarga.builder()
                .id(1)
                .placa("AAAAAAA")
                .marca("Iveco")
                .nome("Stralis")
                .capacidade(50)
                .qtdCarroceria(50)
                .build());
        entities.add(VeiculoDeCarga.builder()
                .id(2)
                .placa("BBBBBBB")
                .marca("Scania")
                .nome("R")
                .capacidade(100)
                .qtdCarroceria(100)
                .build());
        entities.add(VeiculoDeCarga.builder()
                .id(3)
                .placa("CCCCCCC")
                .marca("Volvo")
                .nome("FH")
                .capacidade(90)
                .qtdCarroceria(90)
                .build());
    }

    @Test
    @Order(1)
    void testToDTO() {
        VeiculoDeCarga v = entities.get(0);
        VeiculoDeCargaDTO dto = converter.toDTO(v);

        assertEquals(v.getPlaca(), dto.getPlaca());
        assertEquals(v.getMarca(), dto.getMarca());
        assertEquals(v.getNome(), dto.getNome());
        assertEquals(v.getCapacidade(), dto.getCapacidade());
        assertEquals(v.getQtdCarroceria(), dto.getQtdCarroceria());
    }

    @Test
    @Order(2)
    void testToDTOIter() {
        Iterator<VeiculoDeCargaDTO> dtoIter = converter.toDTOIter(entities).iterator();
        Iterator<VeiculoDeCarga> entityIter = entities.iterator();

        while (dtoIter.hasNext() && entityIter.hasNext()) {
            VeiculoDeCarga v = entityIter.next();
            VeiculoDeCargaDTO dto = dtoIter.next();

            assertEquals(v.getPlaca(), dto.getPlaca());
            assertEquals(v.getMarca(), dto.getMarca());
            assertEquals(v.getNome(), dto.getNome());
            assertEquals(v.getCapacidade(), dto.getCapacidade());
            assertEquals(v.getQtdCarroceria(), dto.getQtdCarroceria());

            dtos.add(dto);
        }
    }

    @Test
    @Order(3)
    void testToEntity() {
        VeiculoDeCargaDTO dto = dtos.get(0);
        VeiculoDeCarga v = converter.toEntity(dto);

        assertEquals(dto.getPlaca(), v.getPlaca());
        assertEquals(dto.getMarca(), v.getMarca());
        assertEquals(dto.getNome(), v.getNome());
        assertEquals(dto.getCapacidade(), v.getCapacidade());
        assertEquals(dto.getQtdCarroceria(), v.getQtdCarroceria());
    }

    @Test
    @Order(4)
    void testToEntityIter() {
        Iterator<VeiculoDeCarga> entityIter = converter.toEntityIter(dtos).iterator();
        Iterator<VeiculoDeCargaDTO> dtoIter = dtos.iterator();

        while (dtoIter.hasNext() && entityIter.hasNext()) {
            VeiculoDeCarga v = entityIter.next();
            VeiculoDeCargaDTO dto = dtoIter.next();

            assertEquals(v.getPlaca(), dto.getPlaca());
            assertEquals(v.getMarca(), dto.getMarca());
            assertEquals(v.getNome(), dto.getNome());
            assertEquals(v.getCapacidade(), dto.getCapacidade());
            assertEquals(v.getQtdCarroceria(), dto.getQtdCarroceria());
        }
    }
}
