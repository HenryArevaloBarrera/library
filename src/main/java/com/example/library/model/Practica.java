package com.example.library.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "practicas")
public class Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String actividad;
    
    private String tipoActividad;
    
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Temporal(TemporalType.DATE)
    private Date fechaRegreso;
    
    private String periodoAcademico;
    private String competencia;
    
    @Column(length = 1000)
    private String descripcion;
    
    // Relaciones con tablas de unión
    @OneToMany(mappedBy = "practica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaDocente> practicasDocentes = new ArrayList<>();
    
    @OneToMany(mappedBy = "practica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaEmpresa> practicasEmpresas = new ArrayList<>();
    
    @OneToMany(mappedBy = "practica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaCurso> practicasCursos = new ArrayList<>();
    
    @OneToMany(mappedBy = "practica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PracticaEstudiante> practicasEstudiantes = new ArrayList<>();
    
    // Constructores
    public Practica() {}
    
    public Practica(String actividad, String tipoActividad, Date fechaSalida, Date fechaRegreso, String periodoAcademico, String competencia, String descripcion) {
        this.actividad = actividad;
        this.tipoActividad = tipoActividad;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.periodoAcademico = periodoAcademico;
        this.competencia = competencia;
        this.descripcion = descripcion;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }
    
    public String getTipoActividad() { return tipoActividad; }
    public void setTipoActividad(String tipoActividad) { this.tipoActividad = tipoActividad; }
    
    public Date getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(Date fechaSalida) { this.fechaSalida = fechaSalida; }
    
    public Date getFechaRegreso() { return fechaRegreso; }
    public void setFechaRegreso(Date fechaRegreso) { this.fechaRegreso = fechaRegreso; }
    
    public String getPeriodoAcademico() { return periodoAcademico; }
    public void setPeriodoAcademico(String periodoAcademico) { this.periodoAcademico = periodoAcademico; }
    
    public String getCompetencia() { return competencia; }
    public void setCompetencia(String competencia) { this.competencia = competencia; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public List<PracticaDocente> getPracticasDocentes() { return practicasDocentes; }
    public void setPracticasDocentes(List<PracticaDocente> practicasDocentes) { this.practicasDocentes = practicasDocentes; }
    
    public List<PracticaEmpresa> getPracticasEmpresas() { return practicasEmpresas; }
    public void setPracticasEmpresas(List<PracticaEmpresa> practicasEmpresas) { this.practicasEmpresas = practicasEmpresas; }
    
    public List<PracticaCurso> getPracticasCursos() { return practicasCursos; }
    public void setPracticasCursos(List<PracticaCurso> practicasCursos) { this.practicasCursos = practicasCursos; }
    
    public List<PracticaEstudiante> getPracticasEstudiantes() { return practicasEstudiantes; }
    public void setPracticasEstudiantes(List<PracticaEstudiante> practicasEstudiantes) { this.practicasEstudiantes = practicasEstudiantes; }
}