package com.example.library.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    private String identificacion;
    
    private String nombre;
    private String programa;
    private Integer creditos;
    private Integer semestre;
    
    @ManyToMany(mappedBy = "cursos")
    private List<Practica> practicas = new ArrayList<>();
    
    public Curso() {
    }
    
    public Curso(String identificacion, String nombre, String programa, Integer creditos, Integer semestre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.programa = programa;
        this.creditos = creditos;
        this.semestre = semestre;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPrograma() {
        return programa;
    }
    
    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    public Integer getSemestre() {
        return semestre;
    }
    
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
    
    public List<Practica> getPracticas() {
        return practicas;
    }
    
    public void setPracticas(List<Practica> practicas) {
        this.practicas = practicas;
    }
}