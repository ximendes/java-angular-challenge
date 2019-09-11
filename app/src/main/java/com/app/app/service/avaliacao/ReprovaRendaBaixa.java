package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

public class ReprovaRendaBaixa implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        if(proposta.isRendaBaixa()){
            proposta.negar();
            proposta.setDescricaoLimite("renda baixa");
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
