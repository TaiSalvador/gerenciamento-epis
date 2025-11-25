package com.senai.gerenciamento_epis.Service;

import com.senai.gerenciamento_epis.DTO.EmprestimoDto;
import com.senai.gerenciamento_epis.Entity.ColaboradorEntity;
import com.senai.gerenciamento_epis.Entity.EpiEntity;
import com.senai.gerenciamento_epis.Entity.EmprestimoEntity;
import com.senai.gerenciamento_epis.Repo.ColaboradorRepository;
import com.senai.gerenciamento_epis.Repo.EpiRepository;
import com.senai.gerenciamento_epis.Repo.EmprestimoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private EpiRepository epiRepository;

    // Create
    public void cadastrar(EmprestimoDto dto) {

        ColaboradorEntity colaborador = colaboradorRepository.findById(dto.getIdColaborador())
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        EpiEntity epi = epiRepository.findById(dto.getIdEpi())
                .orElseThrow(() -> new RuntimeException("EPI não encontrado"));

        EmprestimoEntity emprestimo = new EmprestimoEntity();
        emprestimo.setColaborador(colaborador);
        emprestimo.setEpi(epi);
        emprestimo.setDataEmprestimo(LocalDateTime.now());
        emprestimo.setDataPrevistaDevolucao(dto.getDataPrevistaDevolucao());
        emprestimo.setStatus("EMPRESTADO");
        emprestimo.setObservacao(dto.getObservacao());

        emprestimoRepository.save(emprestimo);
    }

    // Read
    public List<EmprestimoDto> listar() {

        List<EmprestimoEntity> listaEntity = emprestimoRepository.findAll();
        List<EmprestimoDto> listaDTO = new ArrayList<>();

        for (EmprestimoEntity e : listaEntity) {

            EmprestimoDto dto = new EmprestimoDto();

            dto.setIdEmprestimo(e.getId());
            dto.setIdColaborador(e.getColaborador().getId());
            dto.setIdEpi(e.getEpi().getId());
            dto.setDataEmprestimo(e.getDataEmprestimo());
            dto.setDataPrevistaDevolucao(e.getDataPrevistaDevolucao());
            dto.setDataDevolucao(e.getDataDevolucao());
            dto.setStatus(e.getStatus());
            dto.setObservacao(e.getObservacao());

            listaDTO.add(dto);
        }

        return listaDTO;
    }

    // Update
    public void atualizar(Integer id, EmprestimoDto dto) {

        EmprestimoEntity emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        if (dto.getDataDevolucao() != null) {
            emprestimo.setDataDevolucao(dto.getDataDevolucao());
            emprestimo.setStatus("DEVOLVIDO");
        }

        if (dto.getObservacao() != null) {
            emprestimo.setObservacao(dto.getObservacao());
        }

        emprestimoRepository.save(emprestimo);
    }

    // Delete
    public void deletar(Integer id) {
        emprestimoRepository.deleteById(id);
    }
}
