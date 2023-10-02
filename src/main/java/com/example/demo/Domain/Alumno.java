package com.example.demo.Domain;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Alumno")
public class Alumno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Alumno_grade",
            joinColumns = {@JoinColumn(name = "Alumno_id")},
            inverseJoinColumns = {@JoinColumn(name = "Grado_id")}
    )
    private String Last_name;
    private Long id;
    private String code;
    private List<Grade> grades; 

    Alumno(String L_n, Long Id, String c){
        Last_name = L_n;
        id = Id;
        code = c;
    }

    public void setLastName(String lt){
        Last_name = lt;
    }
    public void setCode(String lt){
        code = lt;
    }
    public void setId(Long lt){
        id = lt;
    }

    public String getLastName (){
        return Last_name;
    }
    public String getCode (){
        return code;
    }
    public Long getId (){
        return id;
    }
    public List<Grade> getGrades (){
        return grades;
    }
    

}
