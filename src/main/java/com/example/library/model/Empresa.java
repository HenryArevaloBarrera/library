package com.example.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    private String direccion;
    private String telefono;
    private String sector;
    private String ciudad;
    private String representante;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaEmpresa> practicasEmpresas = new ArrayList<>();
    
    // Constructores
    public Empresa() {}
    
    public Empresa(String nombre, String direccion, String telefono, String sector, String ciudad, String representante) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sector = sector;
        this.ciudad = ciudad;
        this.representante = representante;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
    
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    
    public String getRepresentante() { return representante; }
    public void setRepresentante(String representante) { this.representante = representante; }
    
    public List<PracticaEmpresa> getPracticasEmpresas() { return practicasEmpresas; }
    public void setPracticasEmpresas(List<PracticaEmpresa> practicasEmpresas) { this.practicasEmpresas = practicasEmpresas; }
}