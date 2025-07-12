package com.devmarquinhos.octo.controllers;

import com.devmarquinhos.octo.dto.BeneficiadoRequest;
import com.devmarquinhos.octo.dto.BeneficiadoResponse;
import com.devmarquinhos.octo.services.BeneficiadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiados")
public class BeneficiadoController {

    @Autowired
    private BeneficiadoService service;

    @PostMapping
    public ResponseEntity<BeneficiadoResponse> criarBeneficiado(@RequestBody BeneficiadoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarBeneficiado(request));
    }

    @GetMapping
    public List<BeneficiadoResponse> listarBeneficiados() {
        return service.listarBeneficiados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiadoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BeneficiadoResponse> atualizarParcial(@PathVariable Long id, @RequestBody BeneficiadoRequest request) {
        return ResponseEntity.ok(service.atualizarParcial(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
