package com.app.app.repository;

import com.app.app.model.entity.PropostaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaCreditoRepository extends JpaRepository<PropostaCredito, Long> {


    List<PropostaCredito> findAllByCpfEquals(String cpf);

}
