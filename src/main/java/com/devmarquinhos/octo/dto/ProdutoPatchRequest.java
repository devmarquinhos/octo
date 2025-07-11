package com.devmarquinhos.octo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoPatchRequest {
    private String tipo;
    private String marca;
    private Double peso;
}
