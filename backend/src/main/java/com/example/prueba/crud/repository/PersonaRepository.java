package com.example.prueba.crud.repository;

import com.example.prueba.crud.entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, Integer> {
}
