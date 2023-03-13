package com.br.clamed.pharmacyapi.pharmacyapi.Dto;


import com.br.clamed.pharmacyapi.pharmacyapi.Entity.farmaciaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class cadastroFarmaciaOutput {


    private int status_code;
    private String mensagem;

    private farmaciaEntity dados;


}