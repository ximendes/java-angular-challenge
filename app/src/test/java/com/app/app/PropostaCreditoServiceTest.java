package com.app.app;

import com.app.app.model.dto.PropostaCreditoDTO;
import com.app.app.model.enums.EstadoCivil;
import com.app.app.model.enums.Sexo;
import com.app.app.model.enums.StatusProposta;
import com.app.app.repository.PropostaCreditoRepository;
import com.app.app.service.PropostaCreditoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

public class PropostaCreditoServiceTest extends TestSetup {

    @Autowired
    private PropostaCreditoService propostaCreditoService;

    @Autowired
    private PropostaCreditoRepository propostaCreditoRepository;


    @Test
    public void testeSave(){
        PropostaCreditoDTO proposta = PropostaCreditoDTO.builder()
                                                        .nome("Eduardo Ximendes")
                                                        .cpf("08418248947")
                                                        .idade(29)
                                                        .estado("SC")
                                                        .dependentes(0)
                                                        .renda(new BigDecimal(500.00))
                                                        .sexo(Sexo.MASCULINO)
                                                        .estadoCivil(EstadoCivil.SOLTEIRO)
                                                        .statusProposta(StatusProposta.PENDENTE_APROVACAO)
                                                        .build();

        propostaCreditoService.save(proposta).toEntity();
        assertNotNull(propostaCreditoRepository.findAll().stream().findFirst().orElse(null));
    }

    @Test
    @Sql(scripts = "/cenarios/insert_proposta.sql", config = @SqlConfig(transactionMode = ISOLATED))
    @Sql(scripts = "/cenarios/cleanDatabase.sql", executionPhase = AFTER_TEST_METHOD, config = @SqlConfig(transactionMode = ISOLATED))
    public void testFindAll(){
        List<PropostaCreditoDTO> propostas = propostaCreditoService.findAll();
        assertEquals(3, propostas.size());
    }
}
