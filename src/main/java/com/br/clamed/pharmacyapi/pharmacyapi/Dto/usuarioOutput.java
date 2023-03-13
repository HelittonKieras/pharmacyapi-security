package com.br.clamed.pharmacyapi.pharmacyapi.Dto;


import com.br.clamed.pharmacyapi.pharmacyapi.Entity.usuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class usuarioOutput {

    private int status_code;
    private String mensagem;
    private usuarioEntity dados;



}