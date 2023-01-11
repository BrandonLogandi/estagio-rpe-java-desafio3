package rpe.estagio.desafio3.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.model.repository.VeiculoDeCargaRepository;
import rpe.estagio.desafio3.presentation.dto.VeiculoDeCargaDTO;
import rpe.estagio.desafio3.service.VeiculoDeCargaService;
import rpe.estagio.desafio3.service.converter.VeiculoDeCargaConverter;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class VeiculoDeCargaServiceTest {

    @InjectMocks
    private VeiculoDeCargaService service;
    @Mock
    private VeiculoDeCargaRepository repository;
    @Mock
    private VeiculoDeCargaConverter converter = new VeiculoDeCargaConverter();

    private VeiculoDeCarga expected = VeiculoDeCarga.builder()
            .id(1)
            .placa("AAAAAAA")
            .marca("Iveco")
            .nome("Stralis")
            .capacidade(50)
            .qtdCarroceria(50)
            .build();
    private VeiculoDeCargaDTO expectedDto = VeiculoDeCargaDTO.builder()
            .placa(expected.getPlaca())
            .marca(expected.getMarca())
            .nome(expected.getNome())
            .capacidade(expected.getCapacidade())
            .qtdCarroceria(expected.getQtdCarroceria())
            .build();
    private Iterable<VeiculoDeCarga> expectedIter = Arrays.asList(expected);

    @Test
    void testCreate() throws Exception {
        when(repository.findByPlaca(anyString())).thenReturn(Optional.empty());
        when(repository.save(any(VeiculoDeCarga.class))).thenReturn(expected);
        when(converter.toEntity(any(VeiculoDeCargaDTO.class))).thenReturn(expected);

        VeiculoDeCarga actual = service.create(expectedDto);
        assertEquals(expected, actual);
        verify(repository, times(1)).findByPlaca(anyString());
        verify(repository, times(1)).save(any(VeiculoDeCarga.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testCreateExistent() throws Exception {
        when(repository.findByPlaca(anyString())).thenReturn(Optional.of(expected));

        Exception thrown = assertThrows(Exception.class, () -> {service.create(expectedDto);});
        assertEquals("Veiculo com mesma placa já existe: AAAAAAA", thrown.getMessage());
        verify(repository, times(1)).findByPlaca(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDelete() {
        doNothing().when(repository).deleteById(anyLong());

        service.delete(0l);
        verify(repository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(expectedIter);

        assertEquals(expectedIter, repository.findAll());
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));

        assertEquals(expected, service.findById(0l));
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByInvalidId() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {service.findById(0l);});
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByMarca() {
        when(repository.findByMarca(anyString())).thenReturn(expectedIter);

        assertEquals(expectedIter, service.findByMarca(""));
        verify(repository, times(1)).findByMarca(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByInvalidMarca() {
        when(repository.findByMarca(anyString())).thenReturn(List.of());

        assertTrue(!service.findByMarca("").iterator().hasNext());
        verify(repository, times(1)).findByMarca(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByNome() {
        when(repository.findByNome(anyString())).thenReturn(expectedIter);

        assertEquals(expectedIter, service.findByNome(""));
        verify(repository, times(1)).findByNome(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByInvalidNome() {
        when(repository.findByNome(anyString())).thenReturn(List.of());

        assertTrue(!service.findByNome("").iterator().hasNext());
        verify(repository, times(1)).findByNome(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByPlaca() {
        when(repository.findByPlaca(anyString())).thenReturn(Optional.of(expected));

        assertEquals(expected, service.findByPlaca(""));
        verify(repository, times(1)).findByPlaca(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testFindByInvalidPlaca() {
        when(repository.findByPlaca(anyString())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {service.findByPlaca("");});
        verify(repository, times(1)).findByPlaca(anyString());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdate() {
        VeiculoDeCarga updated = VeiculoDeCarga.builder()
                .id(1)
                .placa("BBBBBBB")
                .marca("Iveco")
                .nome("Hi-Way")
                .capacidade(60)
                .qtdCarroceria(60)
                .build();
        VeiculoDeCargaDTO updatedDto = VeiculoDeCargaDTO.builder()
                .placa(updated.getPlaca())
                .marca(updated.getMarca())
                .nome(updated.getNome())
                .capacidade(updated.getCapacidade())
                .qtdCarroceria(updated.getQtdCarroceria())
                .build();

        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));
        when(repository.save(any(VeiculoDeCarga.class))).thenReturn(updated);

        VeiculoDeCarga actual = service.update(1l, updatedDto);
        assertEquals(updated, actual);
        verify(repository, times(1)).save(any(VeiculoDeCarga.class));
        verifyNoMoreInteractions(repository);
    }
}
