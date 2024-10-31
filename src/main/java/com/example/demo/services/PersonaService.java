package com.example.demo.services;

import com.example.demo.models.Persona;
import com.example.demo.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    public List<Persona> getPersonas(){
        return this.personaRepository.findAll();
    }

    public Optional<Persona> getPersonaById(int idPersona){
        return this.personaRepository.findById(idPersona);
    }

    public Persona postPersona(Persona persona){
        return this.personaRepository.save(persona);
    }

    public Optional<Persona> updatePersona(Persona body){
        Optional<Persona> data = this.personaRepository.findById(body.getId());
        if (data.isPresent()) {
            Persona persona = new Persona(body.getId(), body.getNombre(), body.getApellido(), body.getTelefono(), body.getEmail(), body.getFechaRegistro());
            return Optional.of(this.personaRepository.save(persona));
        }
        return data;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borraPersona(int id){
        Optional<Persona> data = this.personaRepository.findById(id);
        if (data.isPresent()) {
            this.personaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
