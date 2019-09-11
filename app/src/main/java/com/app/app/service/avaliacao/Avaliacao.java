package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

public interface Avaliacao {

    PropostaCredito avalia(PropostaCredito proposta);

    void setProximo(Avaliacao avaliacao);
}
