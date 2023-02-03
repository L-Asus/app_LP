package com.example.prueba.crud.service;

import com.example.prueba.crud.dto.PersonaDto;
import com.example.prueba.crud.entity.Persona;
import com.example.prueba.crud.repository.PersonaRepository;
import org.jpos.iso.ISODate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public Persona getOne(int id) {
        return personaRepository.findById(id).get();
    }

    public Persona save(PersonaDto personaDto) {
        int id = autoIncrement();
        String tag = autoTag(id);
        String createAt = ISODate.getANSIDate(new Date(), TimeZone.getTimeZone(ZoneId.systemDefault()));
        Persona persona = new Persona(id, personaDto.getEmail(), personaDto.getMailPass(), personaDto.getPhone(), personaDto.getCountryPhone(), tag, createAt, personaDto.isActive());
        return personaRepository.save(persona);
    }

    public Persona update(int id, PersonaDto personaDto) {
        Persona persona = personaRepository.findById(id).get();
        persona.setEmail(personaDto.getEmail());
        persona.setMailPass(personaDto.getMailPass());
        persona.setPhone(personaDto.getPhone());
        persona.setCountryPhone(personaDto.getCountryPhone());
        persona.isActive();
        return personaRepository.save(persona);
    }

    public Persona delete(int id) {
        Persona persona = personaRepository.findById(id).get();
        personaRepository.delete(persona);
        return persona;
    }

    public int autoIncrement() {
        List<Persona> persona = personaRepository.findAll();
        return persona.isEmpty() ? 1 : persona.stream().max(Comparator.comparing(Persona::getId)).get().getId() + 1;
    }

    public String autoTag(int id) {
        if(id < 10) {
            return "Pk00" + id;
        }else if(id < 100) {
            return "Pk0" + id;
        }else {
            return "Pk" + id;
        }
    }
}
