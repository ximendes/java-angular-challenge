package com.app.app.service;

import com.app.app.model.entity.PropostaCredito;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class AvaliarLimiteCredito {

    private PropostaCredito propostaCredito;

    public PropostaCredito avaliar(){
        propostaCredito.setLimitePreAprovado(new BigDecimal(10000.00));
        propostaCredito.aprovarProposta();
        propostaCredito.setDescricaoStatus("Entre 500 - 1000");
        return propostaCredito;
    }
}
