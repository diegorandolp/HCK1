package com.example.demo.Domain;


import com.example.demo.Infraestructure.AlumnoRepository;
import com.example.demo.Infraestructure.GradesRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private GradesRepository gradeRepository;

    public List<Grade> getAllAlumnos(){
        return gradeRepository.findAll();
    }

    public Grade saveGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    public Optional<Grade> getGrade(Long id){
        return gradeRepository.findById(id);
    }
    public List<Grade> getAlumnoGrades(Long id){
        Optional <Alumno>student = alumnoRepository.findById(id);
        Alumno al = student.get();
        return al.getGrades();
    }
}