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


    // Create

    public void cadastrarEpi(@Valid EpiDTO epiDTO) {

        EpiEntity epiEntity = new EpiEntity();

        epiEntity.setNomeEpi(epiDTO.getNmEpi());
        epiEntity.setTipoEpi(epiDTO.getTipoEpi());
        epiEntity.setDescricao(epiDTO.getDescricao());
        epiEntity.setTamanho(epiDTO.getTamanho());
        epiEntity.setSituacao(epiDTO.getSituacao());

        if (epiDTO.getValidade() != null) {
            epiEntity.setValidade(java.time.LocalDate.parse(epiDTO.getValidade()));
        }

        epiRepository.save(epiEntity);
    }

    // Read

    public List<EpiDTO> listarEpis() {

        List<EpiEntity> listaEpiEntity = epiRepository.findAll();
        List<EpiDTO> listaEpiDTO = new ArrayList<>();

        for (EpiEntity e : listaEpiEntity) {

            EpiDTO epiDTO = new EpiDTO();

            epiDTO.setIdEpi(e.getId());
            epiDTO.setNmEpi(e.getNomeEpi());
            epiDTO.setTipoEpi(e.getTipoEpi());
            epiDTO.setDescricao(e.getDescricao());
            epiDTO.setTamanho(e.getTamanho());
            epiDTO.setSituacao(e.getSituacao());
            epiDTO.setValidade(e.getValidade() != null ? e.getValidade().toString() : null);

            listaEpiDTO.add(epiDTO);
        }

        return listaEpiDTO;
    }

    // Uptade

    public void atualizarEpi(int id, @Valid EpiDTO epiDTO) {

        EpiEntity epiEntity = epiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EPI não existe"));

        epiEntity.setNomeEpi(epiDTO.getNmEpi());
        epiEntity.setTipoEpi(epiDTO.getTipoEpi());
        epiEntity.setDescricao(epiDTO.getDescricao());
        epiEntity.setTamanho(epiDTO.getTamanho());
        epiEntity.setSituacao(epiDTO.getSituacao());

        if (epiDTO.getValidade() != null) {
            epiEntity.setValidade(java.time.LocalDate.parse(epiDTO.getValidade()));
        }

        epiRepository.save(epiEntity);
    }

    // Delete

    public void deletarEpi(int id) {

        epiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EPI não existe"));

        epiRepository.deleteById(id);
    }
}
