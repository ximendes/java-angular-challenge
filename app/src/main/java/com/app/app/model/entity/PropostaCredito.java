package com.app.app.model.entity;

import com.app.app.model.dto.PropostaCreditoDTO;
import com.app.app.model.enums.EstadoCivil;
import com.app.app.model.enums.Sexo;
import com.app.app.model.enums.StatusProposta;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String descricaoLimite;


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
                                .descricaoLimite(this.descricaoLimite)
                                .build();
    }

    @JsonIgnore
    public void aprovar(){
        this.statusProposta = StatusProposta.APROVADO;
    }

    @JsonIgnore
    public void negar(){
        this.statusProposta = StatusProposta.NEGADO;
    }

    @JsonIgnore
    public boolean isDivorciadoOuViuva(){
        return EstadoCivil.DIVORCIADO.equals(this.estadoCivil) ||
               EstadoCivil.VIUVA.equals(this.estadoCivil);
    }

    public BigDecimal getQuaretaPorcentoRenda(){
        return this.renda.multiply(BigDecimal.valueOf(40)).divide(BigDecimal.valueOf(100));
    }

    public boolean isRendaBaixa(){
        return BigDecimal.valueOf(500.00).compareTo(this.renda) >= 0;
    }

    public boolean isRendaAte3000(){
        return BigDecimal.valueOf(2500.00).compareTo(this.renda) >= 0;
    }
}
