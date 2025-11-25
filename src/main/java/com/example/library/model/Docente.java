package com.example.library.model;

import jakarta.persistence.*;
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
    
    @ManyToMany(mappedBy = "docentes")
    private List<Practica> practicas = new ArrayList<>();
    
    public Docente() {
    }
    
    public Docente(String identificacion, String nombre, String email, String departamento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.email = email;
        this.departamento = departamento;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public List<Practica> getPracticas() {
        return practicas;
    }
    
    public void setPracticas(List<Practica> practicas) {
        this.practicas = practicas;
    }
}