package com.app.app.service;

import com.app.app.model.entity.PropostaCredito;
import com.app.app.service.avaliacao.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AvaliarLimiteCredito {

    private PropostaCredito proposta;

    public PropostaCredito avaliar(){
        Avaliacao rendaBaixa = new ReprovaRendaBaixa();
        Avaliacao politicaCredito = new ReprovaPoliticaCredito();
        Avaliacao aprovaAte500 = new AprovaAte500();
        Avaliacao aprovaAte1000 = new AprovaAte1000();
        Avaliacao aprovaAte1500 = new AprovaAte1500();
        Avaliacao aprovaAte2000 = new AprovaAte2000();
        Avaliacao aprovaSuperior2000 = new AprovaSuperior2000();
        Avaliacao aprovacaoManual = new AprovacaoManual();

        rendaBaixa.setProximo(politicaCredito);
        politicaCredito.setProximo(aprovaAte500);
        aprovaAte500.setProximo(aprovaAte1000);
        aprovaAte1000.setProximo(aprovaAte1500);
        aprovaAte1500.setProximo(aprovaAte2000);
        aprovaAte2000.setProximo(aprovaSuperior2000);
        aprovaSuperior2000.setProximo(aprovacaoManual);

        return rendaBaixa.avalia(proposta);
    }
}
