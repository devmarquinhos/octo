package com.devmarquinhos.octo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devmarquinhos.octo.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNome(String nome);
}
