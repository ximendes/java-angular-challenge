package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AprovaSuperior2000 implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        return rendaSuperior5000(proposta.getRenda()) && rendaDependentesSuperior3000(proposta) ?
               aprovar(proposta) :
               proxima.avalia(proposta);
    }

    private PropostaCredito aprovar(PropostaCredito proposta) {
        proposta.aprovar();
        proposta.setDescricaoLimite("superior 2000");
        return proposta;
    }

    private BigDecimal dependentes(Integer dependentes){
        return BigDecimal.valueOf(dependentes != null && !dependentes.equals(0) ? dependentes : 1);
    }

    private boolean rendaDependentesSuperior3000(PropostaCredito proposta){
        BigDecimal dependentes = this.dependentes(proposta.getDependentes());
        return BigDecimal.valueOf(3000.00).compareTo(proposta.getRenda().divide(dependentes, RoundingMode.HALF_UP)) <= 0;
    }

    private boolean rendaSuperior5000(BigDecimal renda){
        return BigDecimal.valueOf(5000.00).compareTo(renda) <= 0;
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }
}
