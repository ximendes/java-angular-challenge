package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AprovaAte500 implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        return rendaMenor500(proposta) ? aprovar(proposta) : proxima.avalia(proposta);
    }

    private PropostaCredito aprovar(PropostaCredito proposta) {
        proposta.aprovar();
        proposta.setDescricaoLimite("entre 100 - 500");
        return proposta;
    }

    private boolean rendaMenor500(PropostaCredito proposta) {
        BigDecimal dependentes = this.dependentes(proposta.getDependentes());
        BigDecimal valorCalculo = proposta.getQuaretaPorcentoRenda().divide(dependentes, RoundingMode.HALF_DOWN);
        return BigDecimal.valueOf(500).compareTo(valorCalculo) >= 0;
    }

    private BigDecimal dependentes(Integer dependentes){
        return BigDecimal.valueOf(dependentes != null && !dependentes.equals(0) ? dependentes : 1);
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }
}
