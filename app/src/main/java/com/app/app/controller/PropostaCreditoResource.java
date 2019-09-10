package com.app.app.controller;

import com.app.app.model.dto.PropostaCreditoDTO;
import com.app.app.service.PropostaCreditoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PropostaCreditoResource {

    private final PropostaCreditoService service;

    @PostMapping
    @ApiOperation(value = "Cadastrar uma proposta de crédito", response = PropostaCreditoDTO.class)
    public ResponseEntity<PropostaCreditoDTO> save(@RequestBody PropostaCreditoDTO proposta){
        PropostaCreditoDTO order = service.save(proposta);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Buscar proposta de crédito por id", response = PropostaCreditoDTO.class)
    public ResponseEntity<PropostaCreditoDTO> save(@PathVariable Long id){
        PropostaCreditoDTO order = service.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/avaliar/{idProposta}")
    public ResponseEntity.BodyBuilder avaliar(@PathVariable Long idProposta) {
        return ResponseEntity.ok();

    }
}
