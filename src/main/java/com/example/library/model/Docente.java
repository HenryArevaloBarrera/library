package com.example.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    private String identificacion;
    
    @Column(nullable = false)
    private String nombre;
    
    private String email;
    private String departamento;
    
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaDocente> practicasDocentes = new ArrayList<>();
    
    // Constructores
    public Docente() {}
    
    public Docente(String identificacion, String nombre, String email, String departamento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.email = email;
        this.departamento = departamento;
    }
    
    // Getters y Setters
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    
    public List<PracticaDocente> getPracticasDocentes() { return practicasDocentes; }
    public void setPracticasDocentes(List<PracticaDocente> practicasDocentes) { this.practicasDocentes = practicasDocentes; }
}