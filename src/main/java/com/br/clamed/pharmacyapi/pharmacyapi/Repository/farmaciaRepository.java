package com.br.clamed.pharmacyapi.pharmacyapi.Repository;




import com.br.clamed.pharmacyapi.pharmacyapi.Entity.farmaciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface farmaciaRepository extends JpaRepository<farmaciaEntity,Long> {
    Boolean existsByCnpj(String cnpj);
}