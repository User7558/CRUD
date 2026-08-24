package com.marialuiza.CRUD.services;

import com.marialuiza.CRUD.infrastructure.entity.EstudanteEntity;
import com.marialuiza.CRUD.infrastructure.repository.EstudanteRepository;
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
    public List<EstudanteEntity> BuscarEstudante(Long id){
        try {
            return estudanteRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // PUT
    public EstudanteEntity AlterarEstudante(EstudanteEntity estudanteEntity,int matricula){
        EstudanteEntity estudante = estudanteRepository.findByMatricula(matricula);

        if(Objects.isNull(estudante)) {
            throw new RuntimeException("Este aluno não existe.");
        }

        estudanteEntity.setId(estudante.getId());
        return estudanteRepository.save(estudante);
    }
}
