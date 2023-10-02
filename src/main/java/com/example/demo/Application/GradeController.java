package com.example.demo.Application;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Domain.Alumno;
import com.example.demo.Domain.Grade;
import com.example.demo.Domain.GradeService;
import com.example.demo.Exceptions.GradeNotFound;


@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<Grade>> grades() {
        List<Grade> grades = gradeService.getAllAlumnos();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Grade> gradeById(@PathVariable Long id) throws GradeNotFound{
        Optional<Grade> grado = gradeService.getGrade(id);
        return new ResponseEntity<>(grado.get(), HttpStatus.OK);
    }
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<Grade>> gradesByAlumnoId(@PathVariable Long id) throws GradeNotFound{
        List<Grade> grados = gradeService.getAlumnoGrades(id);
        return new ResponseEntity<>(grados, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> saveAlumno(@RequestBody Grade grado) {
        gradeService.saveGrade(grado);
        return ResponseEntity.status(201).body("Created");
    }
}