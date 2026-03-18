package com.trabajo.trabajo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false, length = 120)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(name="anio_publicacion",nullable = false)
    private int anioPublicacion;

    //optional.. todos los ibros deben tener categoria
    //"Fetch".. carga libro carga categoria

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="categoria_id", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    public Libro() {
    }

    public Libro(int anioPublicacion, String autor, Categoria categoria, Long id, String titulo) {
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.categoria = categoria;
        this.id = id;
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "anioPublicacion=" + anioPublicacion +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
