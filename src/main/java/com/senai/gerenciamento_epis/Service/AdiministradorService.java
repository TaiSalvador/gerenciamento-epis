package com.senai.gerenciamento_epis.Service;


import com.senai.gerenciamento_epis.DTO.AdministradorDTO;
import com.senai.gerenciamento_epis.Repo.AdministradoRepository;
import com.senai.gerenciamento_epis.Repo.ColaboradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AdiministradorService {

    @Autowired
    private AdministradoRepository administradorRepo;

    @Autowired
    private ColaboradorRepository colaboradorRepo;


    public void cadastrarAdministrador (@Valid AdministradorDTO administradorDto){


    }



}
