package com.devmarquinhos.octo.services;

import com.devmarquinhos.octo.dto.ProdutoPatchRequest;
import com.devmarquinhos.octo.dto.ProdutoRequest;
import com.devmarquinhos.octo.dto.ProdutoResponse;
import com.devmarquinhos.octo.models.Produto;
import com.devmarquinhos.octo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

// TODO -> Fazer a rota de atualizacao parcial (patch)

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

    public ProdutoResponse buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        return new ProdutoResponse(produto);
    }

    public ProdutoResponse atualizarProduto(Long id, ProdutoPatchRequest request) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        if (request.getTipo() != null) {
            produto.setTipo(request.getTipo());
        }

        if (request.getMarca() != null) {
            produto.setMarca(request.getMarca());
        }

        if (request.getPeso() != null) {
            produto.setPeso(request.getPeso());
        }

        Produto produtoAtualizado = produtoRepository.save(produto);
        return new ProdutoResponse(produtoAtualizado);
    }

    public void deletarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        produtoRepository.delete(produto);
    }
}
