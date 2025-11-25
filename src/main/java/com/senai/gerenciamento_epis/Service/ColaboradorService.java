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
import java.util.List;

@Service
@Validated
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private EpiRepository epiRepository;

    // Create

    public void cadastrarColaborador(@Valid ColaboradorDTO colaboradorDTO) {

        ColaboradorEntity colaboradorEntity = new ColaboradorEntity();

        colaboradorEntity.setNome(colaboradorDTO.getNmColaborador());

        colaboradorRepository.save(colaboradorEntity);
    }

    // Read

    public List<ColaboradorDTO> listarColaboradores() {

        List<ColaboradorEntity> listaColaboradorEntity = colaboradorRepository.findAll();
        List<ColaboradorDTO> listaColaboradorDTO = new ArrayList<>();

        for (ColaboradorEntity c : listaColaboradorEntity) {

            ColaboradorDTO colaboradorDTO = new ColaboradorDTO();

            colaboradorDTO.setIdColaborador(c.getId());
            colaboradorDTO.setNmColaborador(c.getNome());

            listaColaboradorDTO.add(colaboradorDTO);
        }

        return listaColaboradorDTO;
    }

    // Uptade

    public void atualizarColaborador(int id, @Valid ColaboradorDTO colaboradorDTO) {

        ColaboradorEntity colaboradorEntity = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não existe"));

        colaboradorEntity.setNome(colaboradorDTO.getNmColaborador());

        colaboradorRepository.save(colaboradorEntity);
    }

    // Delete

    public void deletarColaborador(int id) {

        ColaboradorEntity colaboradorEntity = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não existe"));

        colaboradorRepository.deleteById(id);
    }
}
