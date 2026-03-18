package com.trabajo.trabajo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity                             //sera una tabla
@Table(name="Categorias")           //sera el nombre de la tabla
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 80)
    private String nombre;

    @Column(nullable = false,length = 150)
    private String descripcion;


    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = false)
    //uno a muchos...campo foraeno....eliminacion................si borra la categoria no borra los libros
    @JsonManagedReference
    private List<Libro>libros = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String descripcion, Long id, List<Libro> libros, String nombre) {
        this.descripcion = descripcion;
        this.id = id;
        this.libros = libros;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "descripcion='" + descripcion + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", libros=" + libros +
                '}';
    }
}

