package com.devmarquinhos.octo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiadoRequest {
    private String responsavel;
    private String telefone;
    private String endereco;
    private String igreja;
}
