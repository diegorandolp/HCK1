package com.example.demo.Application;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Domain.Alumno;
import com.example.demo.Domain.AlumnoService;
import com.example.demo.Exceptions.AlumnnoNotFound;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> alumnos() {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> alumnoById(@PathVariable Long id) throws AlumnnoNotFound{
        Optional<Alumno> student = alumnoService.getAlumno(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> saveAlumno(@RequestBody Alumno alumno) {
        alumnoService.saveAlumno(alumno);
        return ResponseEntity.status(201).body("Created");
    }
/*  
    @PutMapping("/{id}")
    public ResponseEntity<String> playlist(@PathVariable("id") Long id, @RequestBody Playlist playlist) {
        playlistService.updatePlaylist(id, playlist);
        return ResponseEntity.status(200).body("Updated");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchPlaylist(@PathVariable("id") Long id, @RequestBody Playlist playlist) {
        playlistService.patchPlaylist(id, playlist);
        return ResponseEntity.status(200).body("Updated partially");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable("id") Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.status(200).body("Deleted");
    }
 */
}
