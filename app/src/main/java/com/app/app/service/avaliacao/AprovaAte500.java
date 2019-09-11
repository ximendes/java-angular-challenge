package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;

public class AprovaAte500 implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        BigDecimal dependentes = this.dependentes(proposta.getDependentes());
        BigDecimal valorCalculo = proposta.getQuaretaPorcentoRenda().divide(dependentes);
        if(BigDecimal.valueOf(500).compareTo(valorCalculo) >= 0){
            proposta.aprovar();
            proposta.setDescricaoLimite("entre 100 - 500");
            return proposta;
        }else{
            return proxima.avalia(proposta);
        }
    }

    @Override
    public void setProximo(Avaliacao avaliacao) {
        this.proxima = avaliacao;
    }


    private BigDecimal dependentes(Integer dependentes){
        return BigDecimal.valueOf(dependentes != null && !dependentes.equals(0) ? dependentes : 1);
    }
}
