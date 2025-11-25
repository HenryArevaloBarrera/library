package com.example.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    private String codigo;
    
    @Column(nullable = false)
    private String nombre;
    
    private String email;
    private String programaAcademico;
    private Integer semestre;
    private String telefono;
    
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaEstudiante> practicasEstudiantes = new ArrayList<>();
    
    // Constructores
    public Estudiante() {}
    
    public Estudiante(String codigo, String nombre, String email, String programaAcademico, Integer semestre, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.programaAcademico = programaAcademico;
        this.semestre = semestre;
        this.telefono = telefono;
    }
    
    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getProgramaAcademico() { return programaAcademico; }
    public void setProgramaAcademico(String programaAcademico) { this.programaAcademico = programaAcademico; }
    
    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public List<PracticaEstudiante> getPracticasEstudiantes() { return practicasEstudiantes; }
    public void setPracticasEstudiantes(List<PracticaEstudiante> practicasEstudiantes) { this.practicasEstudiantes = practicasEstudiantes; }
}