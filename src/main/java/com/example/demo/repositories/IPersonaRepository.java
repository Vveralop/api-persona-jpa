package com.example.demo.repositories;

import com.example.demo.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IPersonaRepository extends JpaRepository <Persona, Integer> {
}
