package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;

public class ReprovaPoliticaCredito implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        return rendaMenor2000(proposta) && proposta.isDivorciadoOuViuva() ?
               reprovar(proposta) :
               proxima.avalia(proposta);
    }

    private PropostaCredito reprovar(PropostaCredito proposta) {
        proposta.negar();
        proposta.setDescricaoLimite("reprovado pela política de crédito");
        return proposta;
    }

    private boolean rendaMenor2000(PropostaCredito proposta) {
        return BigDecimal.valueOf(2000.00).compareTo(proposta.getRenda()) >= 0;
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }
}
