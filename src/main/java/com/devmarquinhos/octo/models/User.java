package com.devmarquinhos.octo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String senha;
}
