package com.devmarquinhos.octo.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String nome;
    private String senha;
}
