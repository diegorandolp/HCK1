package com.example.demo.Domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Alumno student;
    private Long score;

    Grade (Long Id, Alumno st, Long scr){
        id = Id;
        student = st;
        score = scr;
    }

    void setAlumno (Alumno al){
        student = al;
    }
    void setScore( Long sc){
        score = sc;
    }
    void setId(Long lt){
        id = lt;
    }

    Alumno getAlumno (){
        return student;
    }
    Long getScore( ){
        return score;
    }
    Long getId(){
        return id;
    }
    
}
