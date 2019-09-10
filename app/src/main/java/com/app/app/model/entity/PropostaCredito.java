package com.app.app.model.entity;

import com.app.app.model.dto.PropostaCreditoDTO;
import com.app.app.model.enums.EstadoCivil;
import com.app.app.model.enums.Sexo;
import com.app.app.model.enums.StatusProposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "proposta_credito")
public class PropostaCredito implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String cpf;

    private Integer idade;

    private String estado;

    private Integer dependentes;

    private BigDecimal renda;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;

    public PropostaCreditoDTO toDTO() {
        return PropostaCreditoDTO.builder()
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
