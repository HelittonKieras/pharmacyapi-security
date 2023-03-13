package com.br.clamed.pharmacyapi.pharmacyapi.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "role")
@Getter
@Setter
public class Role implements GrantedAuthority {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRole; /* Papel ROLE_ADMINISTRADOR, ROLE_CADASTRADOR */

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}