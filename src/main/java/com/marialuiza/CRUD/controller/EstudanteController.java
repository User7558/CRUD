package com.marialuiza.CRUD.controller;

import com.marialuiza.CRUD.infrastructure.entity.EstudanteEntity;
import com.marialuiza.CRUD.services.EstudanteService;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    private final EstudanteService estudanteService;
    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @PostMapping("/matricular")
    public ResponseEntity<EstudanteEntity> matricularEstudante(@RequestBody EstudanteEntity estudanteEntity) {
        return ResponseEntity.accepted().body(estudanteService.MatricularEstudante(estudanteEntity));
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletarEstudante(@RequestParam int matricula) {
        estudanteService.DeletarEstudante(matricula);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<EstudanteEntity> buscarEstudante(@RequestParam int matricula) {
        return ResponseEntity.ok().body(estudanteService.BuscarEstudante(matricula));
    }

    @PutMapping("/alterar")
    public ResponseEntity<EstudanteEntity> alterarEstudante(@RequestBody EstudanteEntity estudanteEntity) {
        return ResponseEntity.accepted().body(estudanteService.AlterarEstudante(estudanteEntity));
    }
}
