package com.devmarquinhos.octo.dto;

import com.devmarquinhos.octo.models.Beneficiado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiadoResponse {
    private Long id;
    private String responsavel;
    private String telefone;
    private String endereco;
    private LocalDate dataCadastro;
    private String igreja;

    public BeneficiadoResponse(Beneficiado beneficiado) {
        this.id = beneficiado.getId();
        this.responsavel = beneficiado.getResponsavel();
        this.telefone = beneficiado.getTelefone();
        this.endereco = beneficiado.getEndereco();
        this.dataCadastro = beneficiado.getDataCadastro();
        this.igreja = beneficiado.getIgreja();
    }
}
