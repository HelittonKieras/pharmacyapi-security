package com.br.clamed.pharmacyapi.pharmacyapi.Repository;


import com.br.clamed.pharmacyapi.pharmacyapi.Entity.usuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<usuarioEntity,Long> {

    usuarioEntity findByEmailAndSenha(String email, String senha);

    Boolean existsByEmail(String email);

}