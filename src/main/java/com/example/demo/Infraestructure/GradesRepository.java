package com.example.demo.Infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Domain.Grade;

public interface GradesRepository extends JpaRepository<Grade, Long> {}