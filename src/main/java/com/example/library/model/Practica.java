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
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "practica_docente",
        joinColumns = @JoinColumn(name = "practica_id"),
        inverseJoinColumns = @JoinColumn(name = "docente_id")
    )
    private List<Docente> docentes = new ArrayList<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "practica_empresa",
        joinColumns = @JoinColumn(name = "practica_id"),
        inverseJoinColumns = @JoinColumn(name = "empresa_id")
    )
    private List<Empresa> empresas = new ArrayList<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "practica_curso",
        joinColumns = @JoinColumn(name = "practica_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos = new ArrayList<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "practica_estudiante",
        joinColumns = @JoinColumn(name = "practica_id"),
        inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Estudiante> estudiantes = new ArrayList<>();
    
    public Practica() {
    }
    
    public Practica(String actividad, String tipoActividad, Date fechaSalida, Date fechaRegreso, 
                   String periodoAcademico, String competencia, String descripcion) {
        this.actividad = actividad;
        this.tipoActividad = tipoActividad;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.periodoAcademico = periodoAcademico;
        this.competencia = competencia;
        this.descripcion = descripcion;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getActividad() {
        return actividad;
    }
    
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    public String getTipoActividad() {
        return tipoActividad;
    }
    
    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }
    
    public Date getFechaSalida() {
        return fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public Date getFechaRegreso() {
        return fechaRegreso;
    }
    
    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }
    
    public String getPeriodoAcademico() {
        return periodoAcademico;
    }
    
    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    
    public String getCompetencia() {
        return competencia;
    }
    
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Docente> getDocentes() {
        return docentes;
    }
    
    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }
    
    public List<Empresa> getEmpresas() {
        return empresas;
    }
    
    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public void agregarDocente(Docente docente) {
        this.docentes.add(docente);
        docente.getPracticas().add(this);
    }
    
    public void agregarEmpresa(Empresa empresa) {
        this.empresas.add(empresa);
        empresa.getPracticas().add(this);
    }
    
    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
        curso.getPracticas().add(this);
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
        estudiante.getPracticas().add(this);
    }
}