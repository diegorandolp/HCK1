package com.example.demo.Domain;

import com.example.demo.Exceptions.AlumnnoNotFound;
import com.example.demo.Infraestructure.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> getAlumno(Long id)throws AlumnnoNotFound {
        return alumnoRepository.findById(id);
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> updateAlumno(Long id, Alumno alumno) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        if (optionalAlumno.isPresent()) {
            Alumno existingAlumno = optionalAlumno.get();
            existingAlumno.setId(alumno.getId());
            existingAlumno.setLastName(alumno.getLastName());
            existingAlumno.setCode(alumno.getCode());
            alumnoRepository.save(existingAlumno);
        }
        return optionalAlumno;
    }

    public Optional<Alumno> patchAlumno(Long id, Alumno alumno) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        if (optionalAlumno.isPresent()) {
            Alumno existingAlumno = optionalAlumno.get();
            if (alumno.getId() != null) {
                existingAlumno.setId(alumno.getId());
            }
            if (alumno.getLastName() != null) {
                existingAlumno.setLastName(alumno.getLastName());
            }
            if (alumno.getCode() != null) {
                existingAlumno.setCode(alumno.getCode());
            }
            alumnoRepository.save(existingAlumno);
        }
        return optionalAlumno;
    }

    public Optional<Alumno> deleteAlumno(Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        if (optionalAlumno.isPresent()) {
            alumnoRepository.deleteById(id);
        }
        return optionalAlumno;
    }
}
