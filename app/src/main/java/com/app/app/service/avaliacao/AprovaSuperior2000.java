package com.app.app.service.avaliacao;

import com.app.app.model.entity.PropostaCredito;

import java.math.BigDecimal;

public class AprovaSuperior2000 implements  Avaliacao{

    private Avaliacao proxima;

    @Override
    public PropostaCredito avalia(PropostaCredito proposta) {
        BigDecimal dependentes = this.dependentes(proposta.getDependentes());
        BigDecimal valorCalculo = proposta.getQuaretaPorcentoRenda().divide(dependentes);
        if(valorEntre500E1000(valorCalculo)){
            proposta.aprovar();
            proposta.setDescricaoLimite("entre 500 - 1000");
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

    private boolean valorEntre500E1000(BigDecimal valorCalculo) {
        return BigDecimal.valueOf(500).compareTo(valorCalculo) <= 0 || BigDecimal.valueOf(1000).compareTo(valorCalculo) >= 0;
    }
}
