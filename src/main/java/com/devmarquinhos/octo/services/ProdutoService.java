package com.devmarquinhos.octo.services;

import com.devmarquinhos.octo.dto.ProdutoRequest;
import com.devmarquinhos.octo.dto.ProdutoResponse;
import com.devmarquinhos.octo.models.Produto;
import com.devmarquinhos.octo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponse cadastrarProduto(ProdutoRequest dto){
        Produto produto = new Produto();
        produto.setTipo(dto.getTipo());
        produto.setMarca(dto.getMarca());
        produto.setPeso(dto.getPeso());

        Produto salvo = produtoRepository.save(produto);

        return new ProdutoResponse(salvo.getId(), salvo.getTipo(), salvo.getMarca(), salvo.getPeso());
    }

    public List<ProdutoResponse> listarProdutos(){
        return produtoRepository.findAll().stream()
                .map(produto -> new ProdutoResponse(produto.getId(), produto.getTipo(), produto.getMarca(), produto.getPeso()))
                .collect(Collectors.toList());

    }
}
