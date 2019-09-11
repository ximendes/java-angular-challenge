package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;

public class ReprovaPoliticaCredito implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        if(BigDecimal.valueOf(2000.00).compareTo(proposta.getRenda()) >= 0 && proposta.isDivorciadoOuViuva()){
            proposta.negar();
            proposta.setDescricaoLimite("reprovado pela política de crédito");
            return proposta;
        }else{
            return proxima.avalia(proposta);
        }
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }
}
