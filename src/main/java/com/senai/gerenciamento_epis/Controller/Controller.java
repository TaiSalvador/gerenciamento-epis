package com.senai.gerenciamento_epis.Controller;

import com.senai.gerenciamento_epis.DTO.ColaboradorDTO;
import com.senai.gerenciamento_epis.DTO.EpiDTO;
import com.senai.gerenciamento_epis.DTO.EmprestimoDto;
import com.senai.gerenciamento_epis.Service.ColaboradorService;
import com.senai.gerenciamento_epis.Service.EpisService;
import com.senai.gerenciamento_epis.Service.EmprestimoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private EpisService episService;

    @Autowired
    private EmprestimoService emprestimoService;


    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU GERENCIAMENTO EPIs ===");
            System.out.println("1 - Gerenciar Colaboradores");
            System.out.println("2 - Gerenciar EPIs");
            System.out.println("3 - Gerenciar Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menuColaborador(sc);
                    break;

                case 2:
                    menuEpi(sc);
                    break;

                case 3:
                    menuEmprestimo(sc);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }


    //           Menu Colaborador

    private void menuColaborador(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU COLABORADOR ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    ColaboradorDTO c = new ColaboradorDTO();

                    System.out.print("Nome: ");
                    c.setNmColaborador(sc.nextLine());

                    System.out.print("CPF (11 dígitos): ");
                    c.setCpf(sc.nextLine());

                    System.out.print("Cargo: ");
                    c.setCargo(sc.nextLine());

                    System.out.print("Setor: ");
                    c.setSetor(sc.nextLine());

                    System.out.print("Data admissão (AAAA-MM-DD): ");
                    c.setDataAdmissao(sc.nextLine());

                    c.setStatusAtivo(true);

                    colaboradorService.cadastrarColaborador(c);
                }

                case 2 -> {
                    System.out.println(colaboradorService.listarColaboradores());
                }

                case 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    ColaboradorDTO c = new ColaboradorDTO();

                    System.out.print("Novo nome: ");
                    c.setNmColaborador(sc.nextLine());

                    System.out.print("Novo CPF: ");
                    c.setCpf(sc.nextLine());

                    System.out.print("Novo cargo: ");
                    c.setCargo(sc.nextLine());

                    System.out.print("Novo setor: ");
                    c.setSetor(sc.nextLine());

                    System.out.print("Nova data de admissão (AAAA-MM-DD): ");
                    c.setDataAdmissao(sc.nextLine());

                    colaboradorService.atualizarColaborador(id, c);
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    colaboradorService.deletarColaborador(id);
                }
            }

        } while (opcao != 0);
    }

    //             Menu EPI

    private void menuEpi(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU EPI ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    EpiDTO e = new EpiDTO();

                    System.out.print("Nome EPI: ");
                    e.setNmEpi(sc.nextLine());

                    System.out.print("Tipo: ");
                    e.setTipoEpi(sc.nextLine());

                    System.out.print("Descrição: ");
                    e.setDescricao(sc.nextLine());

                    System.out.print("Tamanho: ");
                    e.setTamanho(sc.nextLine());

                    System.out.print("Validade (AAAA-MM-DD): ");
                    e.setValidade(sc.nextLine());

                    System.out.print("Situação: ");
                    e.setSituacao(sc.nextLine());

                    episService.cadastrarEpi(e);
                }

                case 2 -> System.out.println(episService.listarEpis());

                case 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    EpiDTO e = new EpiDTO();

                    System.out.print("Novo nome: ");
                    e.setNmEpi(sc.nextLine());

                    System.out.print("Novo tipo: ");
                    e.setTipoEpi(sc.nextLine());

                    System.out.print("Nova descrição: ");
                    e.setDescricao(sc.nextLine());

                    System.out.print("Novo tamanho: ");
                    e.setTamanho(sc.nextLine());

                    System.out.print("Nova validade (AAAA-MM-DD): ");
                    e.setValidade(sc.nextLine());

                    System.out.print("Nova situação: ");
                    e.setSituacao(sc.nextLine());

                    episService.atualizarEpi(id, e);
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    episService.deletarEpi(id);
                }
            }

        } while (opcao != 0);
    }

    //          Menu Emprestimo

    private void menuEmprestimo(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU EMPRÉSTIMO ---");
            System.out.println("1 - Empréstimo");
            System.out.println("2 - Listar");
            System.out.println("3 - Devolver");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    EmprestimoDto emp = new EmprestimoDto();

                    System.out.print("ID Colaborador: ");
                    emp.setIdColaborador(sc.nextInt());

                    System.out.print("ID EPI: ");
                    emp.setIdEpi(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Data prevista devolução (AAAA-MM-DD): ");
                    emp.setDataPrevistaDevolucao(LocalDate.parse(sc.nextLine()));

                    System.out.print("Observação: ");
                    emp.setObservacao(sc.nextLine());

                    emprestimoService.cadastrar(emp);
                }

                case 2 -> System.out.println(emprestimoService.listar());

                case 3 -> {
                    System.out.print("ID Empréstimo: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    EmprestimoDto e = new EmprestimoDto();

                    System.out.println("EPI devolvido em: " + LocalDateTime.now());
                    e.setDataDevolucao(LocalDateTime.now());

                    System.out.print("Observação: ");
                    e.setObservacao(sc.nextLine());

                    emprestimoService.atualizar(id, e);
                }

                case 4 -> {
                    System.out.print("ID Empréstimo: ");
                    int id = sc.nextInt();
                    emprestimoService.deletar(id);
                }
            }

        } while (opcao != 0);
    }
}
