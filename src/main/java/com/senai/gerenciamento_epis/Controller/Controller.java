package com.senai.gerenciamento_epis.Controller;

import com.senai.gerenciamento_epis.Service.ColaboradorService;
import com.senai.gerenciamento_epis.Service.EpisService;
import com.senai.gerenciamento_epis.DTO.ColaboradorDTO;
import com.senai.gerenciamento_epis.DTO.EpiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private EpisService episService;

    @Override
    public void run(String... args) throws Exception {

        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("\n=== Sistema de Gestão de EPIs ===");

        do {
            exibirMenu();
            opcao = input.nextInt();

            try {
                switch (opcao) {
                    case 1 -> cadastrarColaborador();
                    case 2 -> listarColaboradores();
                    case 3 -> atualizarColaborador();
                    case 4 -> deletarColaborador();

                    case 5 -> cadastrarEpi();
                    case 6 -> listarEpis();
                    case 7 -> atualizarEpi();
                    case 8 -> deletarEpi();

                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

    }


    // ================= MENU ==================

    private void exibirMenu() {
        System.out.println("""

                ===== MENU =====
                1 - Cadastrar Colaborador
                2 - Listar Colaboradores
                3 - Atualizar Colaborador
                4 - Deletar Colaborador

                5 - Cadastrar EPI
                6 - Listar EPIs
                7 - Atualizar EPI
                8 - Deletar EPI

                0 - Sair
                """);
        System.out.print("Escolha: ");
    }


    // ====================== COLABORADORES ======================

    private void cadastrarColaborador() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String CPF = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        ColaboradorDTO dto = new ColaboradorDTO();
        dto.setNmColaborador(nome);
        dto.setCpf(CPF);
        dto.setCargo(cargo);

        colaboradorService.cadastrarColaborador(dto);
        System.out.println("Colaborador cadastrado!");
    }


    private void listarColaboradores() {
        List<ColaboradorDTO> lista = colaboradorService.listarColaboradores();

        if (lista.isEmpty()) {
            System.out.println("Nenhum colaborador encontrado.");
            return;
        }

        lista.forEach(System.out::println);
    }


    private void atualizarColaborador() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID do colaborador: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Novo cargo: ");
        String cargo = sc.nextLine();

        ColaboradorDTO dto = new ColaboradorDTO();
        dto.setNmColaborador(nome);
        dto.setCargo(cargo);

        colaboradorService.atualizarColaborador(id, dto);
        System.out.println("Colaborador atualizado!");
    }


    private void deletarColaborador() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID: ");
        int id = sc.nextInt();

        colaboradorService.deletarColaborador(id);
        System.out.println("Colaborador removido.");
    }


    // ====================== EPIs ======================

    private void cadastrarEpi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do EPI: ");
        String nome = sc.nextLine();

        System.out.print("Validade (em dias): ");
        int validade = sc.nextInt();

        EpiDTO dto = new EpiDTO();
        dto.setNmEpi(nome);
        dto.setValidade(String.valueOf(validade));

        episService.cadastrarEpi(dto);
        System.out.println("EPI cadastrado!");
    }


    private void listarEpis() {
        List<EpiDTO> lista = episService.listarEpis();

        if (lista.isEmpty()) {
            System.out.println("Nenhum EPI encontrado.");
            return;
        }

        lista.forEach(System.out::println);
    }


    private void atualizarEpi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID do EPI: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Nova validade (dias): ");
        int validade = sc.nextInt();

        EpiDTO dto = new EpiDTO();
        dto.setNmEpi(nome);
        dto.setValidade(String.valueOf(validade));

        episService.atualizarEpi(id, dto);
        System.out.println("EPI atualizado!");
    }


    private void deletarEpi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID: ");
        int id = sc.nextInt();

        episService.deletarEpi(id);
        System.out.println("EPI removido.");
    }

}