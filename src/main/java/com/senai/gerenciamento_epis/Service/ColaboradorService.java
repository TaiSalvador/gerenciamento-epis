package com.senai.gerenciamento_epis.Service;


import com.senai.gerenciamento_epis.DTO.ColaboradorDTO;
import com.senai.gerenciamento_epis.Entity.ColaboradorEntity;
import com.senai.gerenciamento_epis.Repo.ColaboradorRepository;
import com.senai.gerenciamento_epis.Repo.EpiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Validated

public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private EpiRepository epiRepository;

    //CRUD

    // Create

    public void cadastrarColaborador(@Valid ColaboradorDTO colaboradorDTO) {

        ColaboradorEntity colaboradorEntity = new ColaboradorEntity();

        colaboradorEntity.setNmColaborador(colaboradorEntity.getNmColaborador());

        colaboradorRepository.save(colaboradorEntity);
    }

    //Read

    public List<ColaboradorDTO> listaColaboradores() {
        List<ColaboradorEntity> listaColaboradorEntity = colaboradorRepository.findAll();

        List<ColaboradorDTO> listaColaboradorDto = new ArrayList<>();

        for (ColaboradorEntity c : listaColaboradorEntity) {

            ColaboradorDTO colaboradorDTO = new ColaboradorDTO();

            colaboradorDTO.setIdColaborador(c.getIdColaborador());

            listaColaboradorDto.add(colaboradorDTO);

        }

        return listaColaboradorDto;
    }

    //Update

    public void atualizarColaborador (int id, @Valid ColaboradorDTO colaboradorDTO) {

        ColaboradorEntity colaboradorEntity = colaboradorRepository.findById(id).orElseThrow(()  -> new RuntimeException("Colaborador não existe"));

        colaboradorEntity.setNmColaborador(colaboradorDTO.getNmColaborador());

        colaboradorRepository.save(colaboradorEntity);

    }

    public void deletarColaborador(int id){

        colaboradorRepository.findById(id).orElseThrow(() -> new RuntimeException("cColaborador não existe"));

        if (colaboradorRepository.existsById(id)){
            throw new RuntimeException("Não pode deletar departamentos com colaborador");

        }

        colaboradorRepository.deleteAllById(Collections.singleton(id));

    }


}
