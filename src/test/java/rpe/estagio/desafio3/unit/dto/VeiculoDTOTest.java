package rpe.estagio.desafio3.unit.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanVerifier;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;
import rpe.estagio.desafio3.presentation.dto.VeiculoDeCargaDTO;
import rpe.estagio.desafio3.presentation.dto.VeiculoDePasseioDTO;

class VeiculoDTOTest {

    @Test
    @DisplayName("Tests VeiculoDTO and all of its subclasses' methods")
    void testBeans() {
        BeanVerifier.verifyBeansIn("rpe.estagio.desafio3.presentation.dto");
    }

    @Test
    @DisplayName("Tests the builder for CargaDTO")
    void testCargaBuilder() {
        VeiculoDeCarga carga = VeiculoDeCarga.builder()
                .id(1)
                .placa("AAA0000")
                .marca("Iveco")
                .nome("Stralis")
                .capacidade(50)
                .qtdCarroceria(50)
                .build();

        VeiculoDeCargaDTO cargaDTO = VeiculoDeCargaDTO.builder()
                .placa(carga.getPlaca())
                .marca(carga.getMarca())
                .nome(carga.getNome())
                .capacidade(carga.getCapacidade())
                .qtdCarroceria(carga.getQtdCarroceria())
                .build();

        assertEquals(carga.getMarca(), cargaDTO.getMarca());
        assertEquals(carga.getPlaca(), cargaDTO.getPlaca());
        assertEquals(carga.getNome(), cargaDTO.getNome());
        assertEquals(carga.getCapacidade(), cargaDTO.getCapacidade());
        assertEquals(carga.getQtdCarroceria(), cargaDTO.getQtdCarroceria());
    }

    @Test
    @DisplayName("Tests the builder for PasseioDTO")
    void testPasseioBuilder() {
        VeiculoDePasseio passeio = VeiculoDePasseio.builder()
                .id(2)
                .placa("BBB1111")
                .marca("Chevrolet")
                .nome("Volt")
                .numPassageiros(5)
                .build();

        VeiculoDePasseioDTO passeioDTO = VeiculoDePasseioDTO.builder()
                .placa(passeio.getPlaca())
                .marca(passeio.getMarca())
                .nome(passeio.getNome())
                .numPassageiros(passeio.getNumPassageiros())
                .build();

        assertEquals(passeio.getMarca(), passeioDTO.getMarca());
        assertEquals(passeio.getPlaca(), passeioDTO.getPlaca());
        assertEquals(passeio.getNome(), passeioDTO.getNome());
        assertEquals(passeio.getNumPassageiros(), passeioDTO.getNumPassageiros());
    }

}
