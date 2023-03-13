package com.br.clamed.pharmacyapi.pharmacyapi.Repository;



import com.br.clamed.pharmacyapi.pharmacyapi.Entity.medicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface medicamentoRepository extends JpaRepository<medicamentoEntity,Long> {
}