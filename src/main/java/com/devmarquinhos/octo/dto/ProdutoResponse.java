package com.devmarquinhos.octo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {
    private Long id;
    private String tipo;
    private String marca;
    private Double peso;
}
