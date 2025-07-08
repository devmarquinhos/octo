package com.devmarquinhos.octo.dto;

import com.devmarquinhos.octo.models.Produto;
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

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.tipo = produto.getTipo();
        this.marca = produto.getMarca();
        this.peso = produto.getPeso();
    }
}
