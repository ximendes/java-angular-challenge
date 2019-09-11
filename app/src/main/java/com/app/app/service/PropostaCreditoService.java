package com.app.app.service;

import com.app.app.model.dto.PropostaCreditoDTO;
import com.app.app.model.entity.PropostaCredito;
import com.app.app.repository.PropostaCreditoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PropostaCreditoService {

    private final PropostaCreditoRepository repository;

    public PropostaCreditoDTO save(PropostaCreditoDTO proposta){
        PropostaCredito entity = proposta.toEntity();
        return repository.save(entity).toDTO();
    }

    public PropostaCreditoDTO findById(Long id){
        PropostaCredito proposta = repository.findById(id).orElse(new PropostaCredito());
        return proposta.toDTO();
    }

    public List<PropostaCreditoDTO> findAll(){
        return repository.findAll().stream().map(PropostaCredito::toDTO).collect(Collectors.toList());
    }

    public PropostaCreditoDTO avaliar(Long idProposta){
        PropostaCredito proposta = repository.findById(idProposta).orElse(null);
        PropostaCredito propostaAvaliada = new AvaliarLimiteCredito(proposta).avaliar();
        return this.save(propostaAvaliada.toDTO());
    }
}

