package rpe.estagio.desafio3.unit.service.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;
import rpe.estagio.desafio3.presentation.dto.VeiculoDePasseioDTO;
import rpe.estagio.desafio3.service.converter.VeiculoDePasseioConverter;
import rpe.estagio.desafio3.template.DTOConverter;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class VeiculoDePasseioConverterTest {

    private DTOConverter<VeiculoDePasseio, VeiculoDePasseioDTO> converter;
    private List<VeiculoDePasseio> entities;
    private List<VeiculoDePasseioDTO> dtos;

    @BeforeAll
    void setUp() {
        converter = new VeiculoDePasseioConverter();
        entities = new ArrayList<>();
        dtos = new ArrayList<>();

        entities.add(VeiculoDePasseio.builder()
                .id(1)
                .placa("AAAAAAA")
                .marca("Chevrolet")
                .nome("Bolt")
                .numPassageiros(5)
                .build());
        entities.add(VeiculoDePasseio.builder()
                .id(2)
                .placa("BBBBBBB")
                .marca("Jeep")
                .nome("Renegade")
                .numPassageiros(5)
                .build());
        entities.add(VeiculoDePasseio.builder()
                .id(3)
                .placa("CCCCCCC")
                .marca("Toyota")
                .nome("Corolla")
                .numPassageiros(5)
                .build());
    }

    @Test
    @Order(1)
    void testToDTO() {
        VeiculoDePasseio v = entities.get(0);
        VeiculoDePasseioDTO dto = converter.toDTO(v);

        assertEquals(v.getPlaca(), dto.getPlaca());
        assertEquals(v.getMarca(), dto.getMarca());
        assertEquals(v.getNome(), dto.getNome());
        assertEquals(v.getNumPassageiros(), dto.getNumPassageiros());
    }

    @Test
    @Order(2)
    void testToDTOIter() {
        Iterator<VeiculoDePasseioDTO> dtoIter = converter.toDTOIter(entities).iterator();
        Iterator<VeiculoDePasseio> entityIter = entities.iterator();

        while (dtoIter.hasNext() && entityIter.hasNext()) {
            VeiculoDePasseio v = entityIter.next();
            VeiculoDePasseioDTO dto = dtoIter.next();

            assertEquals(v.getPlaca(), dto.getPlaca());
            assertEquals(v.getMarca(), dto.getMarca());
            assertEquals(v.getNome(), dto.getNome());
            assertEquals(v.getNumPassageiros(), dto.getNumPassageiros());

            dtos.add(dto);
        }
    }

    @Test
    @Order(3)
    void testToEntity() {
        VeiculoDePasseioDTO dto = dtos.get(0);
        VeiculoDePasseio v = converter.toEntity(dto);

        assertEquals(v.getPlaca(), dto.getPlaca());
        assertEquals(v.getMarca(), dto.getMarca());
        assertEquals(v.getNome(), dto.getNome());
        assertEquals(v.getNumPassageiros(), dto.getNumPassageiros());
    }

    @Test
    @Order(4)
    void testToEntityIter() {
        Iterator<VeiculoDePasseio> entityIter = converter.toEntityIter(dtos).iterator();
        Iterator<VeiculoDePasseioDTO> dtoIter = dtos.iterator();

        while (dtoIter.hasNext() && entityIter.hasNext()) {
            VeiculoDePasseio v = entityIter.next();
            VeiculoDePasseioDTO dto = dtoIter.next();

            assertEquals(v.getPlaca(), dto.getPlaca());
            assertEquals(v.getMarca(), dto.getMarca());
            assertEquals(v.getNome(), dto.getNome());
            assertEquals(v.getNumPassageiros(), dto.getNumPassageiros());
        }
    }
}
