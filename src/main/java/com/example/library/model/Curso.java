package com.example.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    private String identificacion;
    
    @Column(nullable = false)
    private String nombre;
    
    private String programa;
    private Integer creditos;
    private Integer semestre;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaCurso> practicasCursos = new ArrayList<>();
    
    // Constructores
    public Curso() {}
    
    public Curso(String identificacion, String nombre, String programa, Integer creditos, Integer semestre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.programa = programa;
        this.creditos = creditos;
        this.semestre = semestre;
    }
    
    // Getters y Setters
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }
    
    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }
    
    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }
    
    public List<PracticaCurso> getPracticasCursos() { return practicasCursos; }
    public void setPracticasCursos(List<PracticaCurso> practicasCursos) { this.practicasCursos = practicasCursos; }
}
