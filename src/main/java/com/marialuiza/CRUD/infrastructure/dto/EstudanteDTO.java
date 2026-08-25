package com.marialuiza.CRUD.infrastructure.dto;

import com.marialuiza.CRUD.infrastructure.entity.EstudanteEntity;

public record EstudanteDTO(
        Long id,
        String nome,
        int matricula,
        String email,
        String senha
        ) {
    public static EstudanteDTO from (EstudanteEntity estudanteEntity){
        return new EstudanteDTO(
                estudanteEntity.getId(),
                estudanteEntity.getNome(),
                estudanteEntity.getMatricula(),
                estudanteEntity.getEmail(),
                estudanteEntity.getSenha()
        );
    }
}
