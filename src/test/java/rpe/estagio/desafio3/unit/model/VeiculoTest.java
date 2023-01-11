package rpe.estagio.desafio3.unit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.meanbean.test.BeanVerifier;

import rpe.estagio.desafio3.model.entity.Veiculo;
import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;

class VeiculoTest {

    @Test
    @DisplayName("Tests Veiculo and all of its subclasses' methods")
    void testBeans() {
        BeanVerifier.verifyBeansIn("rpe.estagio.desafio3.model.entity");
    }

    @Test
    @DisplayName("Tests the builders for Veiculo's subclasses")
    void testBuilders() {
        Veiculo carga = VeiculoDeCarga.builder()
                .id(1)
                .placa("AAA0000")
                .marca("Iveco")
                .nome("Stralis")
                .capacidade(50)
                .qtdCarroceria(50)
                .build();
        Veiculo passeio = VeiculoDePasseio.builder()
                .id(2)
                .placa("BBB0000")
                .marca("Chevrolet")
                .nome("Volt")
                .numPassageiros(5)
                .build();

        assertInstanceOf(VeiculoDeCarga.class, carga);
        assertInstanceOf(VeiculoDePasseio.class, passeio);
        assertEquals(1, carga.getId());
        assertEquals(2, passeio.getId());
    }

}
