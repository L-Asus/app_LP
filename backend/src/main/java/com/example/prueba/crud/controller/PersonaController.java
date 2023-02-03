package com.example.prueba.crud.controller;

import com.example.prueba.crud.dto.PersonaDto;
import com.example.prueba.crud.entity.Persona;
import com.example.prueba.crud.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll() {
        return ResponseEntity.ok(personaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getOne(@PathVariable("id") int id) {
        return ResponseEntity.ok(personaService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody PersonaDto personaDto) {
        return ResponseEntity.ok(personaService.save(personaDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable("id") int id, @RequestBody PersonaDto personaDto) {
        return ResponseEntity.ok(personaService.update(id, personaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(personaService.delete(id));
    }
}
