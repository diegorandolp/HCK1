package com.example.demo.Infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {}