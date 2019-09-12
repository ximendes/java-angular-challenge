package com.app.app.model.dto;

import com.app.app.model.entity.PropostaCredito;
import com.app.app.model.enums.EstadoCivil;
import com.app.app.model.enums.Sexo;
import com.app.app.model.enums.StatusProposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropostaCreditoDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "Nome Obrigatório")
    private String nome;
    @NotEmpty(message = "CPF Obrigatório")
    private String cpf;
    @NotNull(message = "Idade Obrigatório")
    private Integer idade;
    @NotNull(message = "Estado Obrigatório")
    private String estado;
    @NotNull(message = "Numero de Dependentes Obrigatório")
    private Integer dependentes;
    @NotNull(message = "Renda Obrigatório")
    @DecimalMin("1.00")
    private BigDecimal renda;
    @NotNull(message = "Sexo Obrigatório")
    private Sexo sexo;
    @NotNull(message = "Estado Civil Obrigatório")
    private EstadoCivil estadoCivil;
    private StatusProposta statusProposta;
    private String descricaoLimite;

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
                            .descricaoLimite(this.descricaoLimite)
                            .build();
    }


    public void pendenteAprovacao(){
        this.statusProposta = StatusProposta.PENDENTE_APROVACAO;
    }
}
