package Service;


import DTO.ColaboradorDTO;
import Entity.ColaboradorEntity;
import Repo.ColaboradorRepository;
import Repo.EpiRepository;
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
            colaboradorDTO.setNmColaborador(c.getNmColaborador());

            listaColaboradorDto.add(colaboradorDTO);

        }

        return listaColaboradorDto;
    }

    //Update

    public void atualizarColaborador (int id, @Valid ColaboradorDTO colaboradorDTO) {

        ColaboradorEntity colaboradorEntity = colaboradorRepository.findById(id).orElseThrow(()  -> new RuntimeException("Colaborador não existe"));


    }
}
