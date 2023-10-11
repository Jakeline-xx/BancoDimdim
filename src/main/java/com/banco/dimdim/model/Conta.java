package com.banco.dimdim.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private Integer saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
