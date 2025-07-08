package com.devmarquinhos.octo.repository;

import com.devmarquinhos.octo.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
