package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AprovaAte1000 implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        return proposta.isRendaAte3000() && valorCalculadoEntre500E1000(proposta) ? aprovar(proposta) : proxima.avalia(proposta);
    }

    private PropostaCredito aprovar(PropostaCredito proposta) {
        proposta.aprovar();
        proposta.setDescricaoLimite("entre 500 - 1000");
        return proposta;
    }

    private BigDecimal dependentes(Integer dependentes){
        return BigDecimal.valueOf(dependentes != null && !dependentes.equals(0) ? dependentes : 1);
    }

    private boolean valorCalculadoEntre500E1000(PropostaCredito proposta) {
        BigDecimal dependentes = this.dependentes(proposta.getDependentes());
        BigDecimal valorCalculo = proposta.getQuaretaPorcentoRenda().divide(dependentes, RoundingMode.HALF_UP);
        return BigDecimal.valueOf(500).compareTo(valorCalculo) <= 0 || BigDecimal.valueOf(1000).compareTo(valorCalculo) >= 0;
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }
}
