package com.senai.gerenciamento_epis.Service;

import com.senai.gerenciamento_epis.DTO.ColaboradorDTO;
import com.senai.gerenciamento_epis.Entity.ColaboradorEntity;
import com.senai.gerenciamento_epis.Repo.ColaboradorRepository;
import com.senai.gerenciamento_epis.Repo.EpiRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // CREATE
    public void cadastrarColaborador(@Valid ColaboradorDTO dto) {

        ColaboradorEntity entity = new ColaboradorEntity();

        entity.setNome(dto.getNmColaborador());
        entity.setCpf(dto.getCpf());
        entity.setCargo(dto.getCargo());
        entity.setSetor(dto.getSetor());

        // Converte String → LocalDate
        if (dto.getDataAdmissao() != null && !dto.getDataAdmissao().isEmpty()) {
            entity.setDataAdmissao(LocalDate.parse(dto.getDataAdmissao()));
        }

        entity.setStatusAtivo(dto.isStatusAtivo());

        colaboradorRepository.save(entity);
    }

    // READ
    public List<ColaboradorDTO> listarColaboradores() {

        List<ColaboradorDTO> lista = new ArrayList<>();

        for (ColaboradorEntity c : colaboradorRepository.findAll()) {

            ColaboradorDTO dto = new ColaboradorDTO();

            dto.setIdColaborador(c.getId());
            dto.setNmColaborador(c.getNome());
            dto.setCpf(c.getCpf());
            dto.setCargo(c.getCargo());
            dto.setSetor(c.getSetor());

            if (c.getDataAdmissao() != null) {
                dto.setDataAdmissao(c.getDataAdmissao().toString());
            }

            dto.setStatusAtivo(Boolean.TRUE.equals(c.getStatusAtivo()));

            lista.add(dto);
        }

        return lista;
    }

    // UPDATE
    public void atualizarColaborador(int id, @Valid ColaboradorDTO dto) {

        ColaboradorEntity entity = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não existe"));

        entity.setNome(dto.getNmColaborador());
        entity.setCpf(dto.getCpf());
        entity.setCargo(dto.getCargo());
        entity.setSetor(dto.getSetor());

        if (dto.getDataAdmissao() != null && !dto.getDataAdmissao().isEmpty()) {
            entity.setDataAdmissao(LocalDate.parse(dto.getDataAdmissao()));
        }

        entity.setStatusAtivo(dto.isStatusAtivo());

        colaboradorRepository.save(entity);
    }

    // DELETE
    public void deletarColaborador(int id) {

        ColaboradorEntity entity = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não existe"));

        colaboradorRepository.delete(entity);
    }

}
