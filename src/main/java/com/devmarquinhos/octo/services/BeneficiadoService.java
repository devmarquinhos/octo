package com.devmarquinhos.octo.services;

import com.devmarquinhos.octo.dto.BeneficiadoRequest;
import com.devmarquinhos.octo.dto.BeneficiadoResponse;
import com.devmarquinhos.octo.models.Beneficiado;
import com.devmarquinhos.octo.repository.BeneficiadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class BeneficiadoService {
    @Autowired
    private BeneficiadoRepository beneficiadoRepository;

    public BeneficiadoResponse criarBeneficiado(BeneficiadoRequest request){
        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setResponsavel(request.getResponsavel());
        beneficiado.setTelefone(request.getTelefone());
        beneficiado.setEndereco(request.getEndereco());
        beneficiado.setIgreja(request.getIgreja());
        beneficiado.setDataCadastro(LocalDate.now());

        return new BeneficiadoResponse(beneficiadoRepository.save(beneficiado));
    }

    public List<BeneficiadoResponse> listarBeneficiados(){
        return beneficiadoRepository.findAll().stream().map(BeneficiadoResponse::new).toList();
    }

    public BeneficiadoResponse buscarPorId(Long id){
        Beneficiado beneficiado = beneficiadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new BeneficiadoResponse(beneficiado);
    }

    public BeneficiadoResponse atualizarParcial(Long id, BeneficiadoRequest request) {
        Beneficiado beneficiado = beneficiadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (request.getResponsavel() != null) beneficiado.setResponsavel(request.getResponsavel());
        if (request.getTelefone() != null) beneficiado.setTelefone(request.getTelefone());
        if (request.getEndereco() != null) beneficiado.setEndereco(request.getEndereco());
        if (request.getIgreja() != null) beneficiado.setIgreja(request.getIgreja());

        return new BeneficiadoResponse(beneficiadoRepository.save(beneficiado));
    }

    public void deletar(Long id) {
        if (!beneficiadoRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        beneficiadoRepository.deleteById(id);
    }
}
