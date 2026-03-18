package com.trabajo.trabajo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.*;
import java.util.Set;

@Entity
@Table(name="Estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 80)
    private String nombre;

    @Column(nullable = false, unique = true, length = 120)
    private String correo;


    @ManyToMany
    @JoinTable(
            name="estudiante_curso",
            joinColumns = @JoinColumn(name="estudiante_id"),
            inverseJoinColumns = @JoinColumn(name="curso_id")
    )
    @JsonProperty("estudiantes")
    private Set<Curso>cursos= new HashSet<>();

    public Estudiante() {
    }

    public Estudiante(String correo, Set<Curso> cursos, Long id, String nombre) {
        this.correo = correo;
        this.cursos = cursos;
        this.id = id;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
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
        return "Estudiante{" +
                "correo='" + correo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
