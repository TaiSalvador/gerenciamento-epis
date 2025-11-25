package com.senai.gerenciamento_epis.Service;


import com.senai.gerenciamento_epis.DTO.EpiDTO;
import com.senai.gerenciamento_epis.Entity.EpiEntity;
import com.senai.gerenciamento_epis.Repo.ColaboradorRepository;
import com.senai.gerenciamento_epis.Repo.EpiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;


@Service
@Validated
public class EpisService {

    @Autowired
    private EpiRepository epiRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    //CRUD

    //Create

    public void cadastrarEpi (@Valid EpiDTO  epiDTO) {

        EpiEntity epiEntity = new EpiEntity();

        epiEntity.setNm_epis(epiDTO.getNome());

        epiRepository.save(epiEntity);
    }

    // Read
    public List<EpiDTO> listarEpis () {

        List<EpiEntity> listaEpiEntity = epiRepository.findAll();

        List<EpiDTO> listaEpiDTO = new ArrayList<>();

        for (EpiEntity e : listaEpiEntity) {

            EpiDTO epiDTO = new EpiDTO();

            epiDTO.setNome(e.getNm_epis());

            listaEpiDTO.add(epiDTO);
        }

        return listaEpiDTO;
    }

    //Update

    //public void atualizaEpi (int id, @Valid EpiDTO epiDTO) {
        //EpiEntity epiEntity = epiRepository.findById(id).orElseThrow(() -> new RuntimeException("Epi não existe"));

        //if (epiRepository.ex)
   // }
}
