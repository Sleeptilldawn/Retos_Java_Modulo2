package com.ejemplo.productos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    public Marca() {}

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Marca[id=" + id + ", nombre='" + nombre + "']";
    }
}
