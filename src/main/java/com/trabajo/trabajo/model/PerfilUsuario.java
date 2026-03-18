package com.trabajo.trabajo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Entity
@Table(name="perfil_usuario")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 120)
    private String documento;

    @Column(nullable = false ,length = 20)
    private int telefono;

    //garantiza que todos los usuarios tengan perfil
    @OneToOne(optional = false)
    @JoinColumn(name="usuarui_id",nullable = false,unique = true)
    @JsonIgnoreProperties("perfil")
    private Usuario usuario;

    public PerfilUsuario() {
    }

    public PerfilUsuario(String documento, Long id, int telefono, Usuario usuario) {
        this.documento = documento;
        this.id = id;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "PerfilUsuario{" +
                "documento='" + documento + '\'' +
                ", id=" + id +
                ", telefono=" + telefono +
                ", usuario=" + usuario +
                '}';
    }
}
