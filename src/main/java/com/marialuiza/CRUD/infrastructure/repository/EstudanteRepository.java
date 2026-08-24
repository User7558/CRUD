package com.marialuiza.CRUD.infrastructure.repository;

import com.marialuiza.CRUD.infrastructure.entity.EstudanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<EstudanteEntity, Long> {
    EstudanteEntity findByMatricula(int matricula);
    EstudanteEntity findByEmail(String email);
    Optional<EstudanteEntity> findById(Long id);

    @Transactional
    void deleteByMatricula(int matricula);


}
