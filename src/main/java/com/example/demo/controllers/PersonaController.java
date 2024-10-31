package com.example.demo.controllers;

import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public List<Persona> getPersonas(){
        return this.personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public Optional<Persona> getPersonaById(@PathVariable int id){
        return this.personaService.getPersonaById(id);
    }

    @PostMapping()
    public Persona postPersona(@RequestBody Persona body){
        return this.personaService.postPersona(body);
    }

    @PutMapping()
    public Optional<Persona> updatePersona(@RequestBody Persona body){
        return this.personaService.updatePersona(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable int id){
        return this.personaService.borraPersona(id);
    }

}
