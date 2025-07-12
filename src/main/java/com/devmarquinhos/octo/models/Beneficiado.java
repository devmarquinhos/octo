package com.devmarquinhos.octo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "beneficiados")
public class Beneficiado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsavel;
    private String telefone;
    private String endereco;

    @Column(name = "data_cad")
    private LocalDate dataCadastro;

    private String igreja;
}
