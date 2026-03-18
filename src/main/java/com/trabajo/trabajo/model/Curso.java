package com.trabajo.trabajo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    protected int creditos;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnoreProperties("cursos")
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Curso() {
    }

    public Curso(int creditos, Set<Estudiante> estudiantes, Long id, String nombre) {
        this.creditos = creditos;
        this.estudiantes = estudiantes;
        this.id = id;
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "creditos=" + creditos +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
