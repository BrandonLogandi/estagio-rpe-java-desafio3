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

import rpe.estagio.desafio3.model.entity.VeiculoDePasseio;
import rpe.estagio.desafio3.presentation.dto.VeiculoDePasseioDTO;
import rpe.estagio.desafio3.service.VeiculoDePasseioService;

@RestController
@RequestMapping(value = "/veiculoDePasseio")
public class VeiculoDePasseioController {

    @Autowired
    private VeiculoDePasseioService service;

    @PostMapping
    public ResponseEntity<VeiculoDePasseio> create(@RequestBody VeiculoDePasseioDTO dto) throws Exception {
        try {
            return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<VeiculoDePasseio> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/placa/{placa}")
    public ResponseEntity<VeiculoDePasseio> findByPlaca(@PathVariable String placa) {
        try {
            return new ResponseEntity<>(service.findByPlaca(placa), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/nome/{nome}")
    public ResponseEntity<Iterable<VeiculoDePasseio>> findByNome(@PathVariable String nome) {
        try {
            return new ResponseEntity<>(service.findByNome(nome), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/marca/{marca}")
    public ResponseEntity<Iterable<VeiculoDePasseio>> findByMarca(@PathVariable String marca) {
        try {
            return new ResponseEntity<>(service.findByMarca(marca), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<VeiculoDePasseio>> findAll() {
        try {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<VeiculoDePasseio> update(@RequestParam Long id, @RequestBody VeiculoDePasseioDTO dto) {
        try {
            return new ResponseEntity<>(service.update(id, dto), HttpStatus.CREATED);
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
