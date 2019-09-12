package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

public class ReprovaRendaBaixa implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        return proposta.isRendaBaixa() ? reprovar(proposta) : proxima.avalia(proposta);
    }

    private PropostaCredito reprovar(PropostaCredito proposta) {
        proposta.negar();
        proposta.setDescricaoLimite("renda baixa");
        return proposta;
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }
}
