package com.marialuiza.CRUD.services;

import com.marialuiza.CRUD.infrastructure.entity.EstudanteEntity;
import com.marialuiza.CRUD.infrastructure.repository.EstudanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;
    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    // POST
    public EstudanteEntity MatricularEstudante(EstudanteEntity estudanteEntity) {

        int MatriculaCheck = estudanteEntity.getMatricula();
        String EmailCheck = estudanteEntity.getEmail();
        EstudanteEntity MatriculasCriadas = estudanteRepository.findByMatricula(MatriculaCheck);
        EstudanteEntity EmailsCriados = estudanteRepository.findByEmail(EmailCheck);

        if(Objects.isNull(MatriculasCriadas) && Objects.isNull(EmailsCriados)) {
            return estudanteRepository.save(estudanteEntity);
        }
        else {
            throw new RuntimeException("Email ou senha já existente.");
        }
    }

    // DEL
    public void DeletarEstudante(int matricula) {
        estudanteRepository.deleteByMatricula(matricula);
    }

    // GET
    public EstudanteEntity BuscarEstudante(int matricula){
        try {
            return estudanteRepository.findByMatricula(matricula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // PUT
    public EstudanteEntity AlterarEstudante(EstudanteEntity estudanteEntity){
        EstudanteEntity estudanteb = estudanteRepository.getEstudanteEntityById(estudanteEntity.getId());

        if(Objects.isNull(estudanteb)) {
            throw new RuntimeException("Este aluno não existe.");
        }

        return estudanteRepository.save(estudanteEntity);
    }
}
