package com.app.app.repository;

import com.app.app.model.entity.PropostaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface PropostaCreditoRepository extends JpaRepository<PropostaCredito, Long> {
}
