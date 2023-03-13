package com.br.clamed.pharmacyapi.pharmacyapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class enderecoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estade;
    private String complemento;
    private String latitude;
    private String longitude;



    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", ='" +  + '\'' +
                ", ='" +  + '\'' +
                '}';
    }
}
