package com.br.clamed.pharmacyapi.pharmacyapi.Dto;



import com.br.clamed.pharmacyapi.pharmacyapi.Entity.medicamentoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class listaMedicamentoOutput {
    private int status_code;
    private String mensagem;
    private List<medicamentoEntity> dados;

}