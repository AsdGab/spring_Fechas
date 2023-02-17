package com.Fechas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tienda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "hora")
    private LocalTime hora;

    public Tienda(String nombre, LocalDateTime fecha, LocalTime hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }
}
