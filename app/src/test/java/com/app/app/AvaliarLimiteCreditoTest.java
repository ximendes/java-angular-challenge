package com.app.app;

import com.app.app.model.entity.PropostaCredito;
import com.app.app.model.enums.EstadoCivil;
import com.app.app.model.enums.Sexo;
import com.app.app.model.enums.StatusProposta;
import com.app.app.service.AvaliarLimiteCredito;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AvaliarLimiteCreditoTest {

    @Test
    public void deveReprovarRendaBaixa(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(29)
                                                  .dependentes(0)
                                                  .renda(new BigDecimal(500.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.SOLTEIRO)
                                                  .build();

        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.NEGADO, propostaAvaliada.getStatusProposta());
        assertEquals("renda baixa", propostaAvaliada.getDescricaoLimite());
    }

    @Test
    public void deveReprovarPoliticaCredito(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(63)
                                                  .dependentes(3)
                                                  .renda(new BigDecimal(2000.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.DIVORCIADO)
                                                  .build();
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.NEGADO, propostaAvaliada.getStatusProposta());
        assertEquals("reprovado pela política de crédito", propostaAvaliada.getDescricaoLimite());
    }

    @Test
    public void deveAprovarAte500(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(17)
                                                  .dependentes(0)
                                                  .renda(new BigDecimal(1000.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.SOLTEIRO)
                                                  .build();
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.APROVADO, propostaAvaliada.getStatusProposta());
        assertEquals("entre 100 - 500", propostaAvaliada.getDescricaoLimite());

    }

    @Test
    public void deveAprovarAte1000(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(28)
                                                  .dependentes(0)
                                                  .renda(new BigDecimal(2500.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.SOLTEIRO)
                                                  .build();
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.APROVADO, propostaAvaliada.getStatusProposta());
        assertEquals("entre 500 - 1000", propostaAvaliada.getDescricaoLimite());

    }

    @Test
    public void deveAprovarAte1500(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(68)
                                                  .dependentes(3)
                                                  .renda(new BigDecimal(5000.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.SOLTEIRO)
                                                  .build();
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.APROVADO, propostaAvaliada.getStatusProposta());
        assertEquals("entre 1000 - 1500", propostaAvaliada.getDescricaoLimite());

    }

    @Test
    public void deveAprovarAte2000(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(68)
                                                  .dependentes(3)
                                                  .renda(new BigDecimal(8000.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.CASADO)
                                                  .build();
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.APROVADO, propostaAvaliada.getStatusProposta());
        assertEquals("entre 1500 - 2000", propostaAvaliada.getDescricaoLimite());

    }

    @Test
    public void deveAprovarAcima2000(){

        PropostaCredito proposta = PropostaCredito.builder()
                                                  .idade(30)
                                                  .dependentes(2)
                                                  .renda(new BigDecimal(8000.00))
                                                  .sexo(Sexo.MASCULINO)
                                                  .estadoCivil(EstadoCivil.CASADO)
                                                  .build();
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();

        assertEquals(StatusProposta.APROVADO, propostaAvaliada.getStatusProposta());
        assertEquals("superior 2000", propostaAvaliada.getDescricaoLimite());

    }
}