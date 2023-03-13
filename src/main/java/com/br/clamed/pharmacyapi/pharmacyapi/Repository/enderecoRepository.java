package com.br.clamed.pharmacyapi.pharmacyapi.Repository;



import com.br.clamed.pharmacyapi.pharmacyapi.Entity.enderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface enderecoRepository extends JpaRepository<enderecoEntity,Long> {
}