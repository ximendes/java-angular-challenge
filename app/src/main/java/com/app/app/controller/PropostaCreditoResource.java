package com.app.app.controller;

import com.app.app.model.dto.PropostaCreditoDTO;
import com.app.app.service.PropostaCreditoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:8000")
public class PropostaCreditoResource {

    private final PropostaCreditoService service;

    @PostMapping
    @ApiOperation(value = "Cadastrar uma proposta de crédito", response = PropostaCreditoDTO.class)
    public ResponseEntity<PropostaCreditoDTO> save(@RequestBody PropostaCreditoDTO proposta){
        proposta.pendenteAprovacao();
        PropostaCreditoDTO propostaSave = service.save(proposta);
        return ResponseEntity.ok(propostaSave);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Buscar proposta de crédito por id", response = PropostaCreditoDTO.class)
    public ResponseEntity<PropostaCreditoDTO> save(@PathVariable Long id){
        PropostaCreditoDTO order = service.findById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "Buscar todas as proposta de crédito", response = PropostaCreditoDTO.class)
    public ResponseEntity<List<PropostaCreditoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/avaliar")
    @ApiOperation(value = "Avaliar proposta de crédito")
    public ResponseEntity<PropostaCreditoDTO> avaliar(@RequestBody Long idProposta) {
        PropostaCreditoDTO avaliar = service.avaliar(idProposta);
        return ResponseEntity.ok(avaliar);
    }
}
