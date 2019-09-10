package com.app.app.model.dto;

import com.app.app.model.entity.PropostaCredito;
import com.app.app.model.enums.EstadoCivil;
import com.app.app.model.enums.Sexo;
import com.app.app.model.enums.StatusProposta;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropostaCreditoDTO implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String estado;
    private Integer dependentes;
    private BigDecimal renda;
    private Sexo sexo;
    private EstadoCivil estadoCivil;
    private StatusProposta statusProposta;

    public PropostaCredito toEntity(){
        return PropostaCredito.builder()
                            .id(this.id)
                            .nome(this.nome)
                            .cpf(this.cpf)
                            .idade(this.idade)
                            .estado(this.estado)
                            .dependentes(this.dependentes)
                            .renda(this.renda)
                            .sexo(this.sexo)
                            .estadoCivil(this.estadoCivil)
                            .statusProposta(this.statusProposta)
                            .build();
    }
}
