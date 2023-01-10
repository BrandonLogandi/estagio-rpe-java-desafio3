package rpe.estagio.desafio3.presentation.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rpe.estagio.desafio3.model.entity.VeiculoDeCarga;
import rpe.estagio.desafio3.presentation.dto.VeiculoDeCargaDTO;
import rpe.estagio.desafio3.service.VeiculoDeCargaService;
import rpe.estagio.desafio3.template.DTOConverter;

@RestController
@RequestMapping(value = "/veiculoDeCarga")
public class VeiculoDeCargaController {

    @Autowired
    private VeiculoDeCargaService service;
    @Autowired
    private DTOConverter<VeiculoDeCarga, VeiculoDeCargaDTO> converter;

    @PostMapping
    public ResponseEntity<VeiculoDeCargaDTO> create(@RequestBody VeiculoDeCargaDTO dto) throws Exception {
        try {
            return new ResponseEntity<>(converter.toDTO(service.create(dto)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<VeiculoDeCargaDTO> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(converter.toDTO(service.findById(id)), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/placa/{placa}")
    public ResponseEntity<VeiculoDeCargaDTO> findByPlaca(@PathVariable String placa) {
        try {
            return new ResponseEntity<>(converter.toDTO(service.findByPlaca(placa)), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/nome/{nome}")
    public ResponseEntity<Iterable<VeiculoDeCargaDTO>> findByNome(@PathVariable String nome) {
        try {
            return new ResponseEntity<>(converter.toDTOIter(service.findByNome(nome)), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/marca/{marca}")
    public ResponseEntity<Iterable<VeiculoDeCargaDTO>> findByMarca(@PathVariable String marca) {
        try {
            return new ResponseEntity<>(converter.toDTOIter(service.findByMarca(marca)), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<VeiculoDeCargaDTO>> findAll() {
        try {
            return new ResponseEntity<>(converter.toDTOIter(service.findAll()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<VeiculoDeCargaDTO> update(@RequestParam Long id, @RequestBody VeiculoDeCargaDTO dto) {
        try {
            return new ResponseEntity<>(converter.toDTO(service.update(id, dto)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestParam Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
