package com.br.clamed.pharmacyapi.pharmacyapi.Dto;



import com.br.clamed.pharmacyapi.pharmacyapi.Entity.farmaciaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class farmaciaidOutput {
    private int status_code;
    private String mensagem;
    private Optional<farmaciaEntity> dados;

}