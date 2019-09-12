package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;
import com.app.app.model.enums.StatusProposta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AprovacaoManual implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        proposta.setStatusProposta(StatusProposta.PENDENTE_APROVACAO_MANUAL);
        return proposta;
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        //sem próximo
    }
}
