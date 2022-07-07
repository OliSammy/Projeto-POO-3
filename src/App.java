
import java.util.Scanner;

import controlador.*;
import entidades.*;
import exceptions.*;
import paineis.MenuPrincipal;
import servicos.Consulta;
import servicos.Inicializador;

public class App {
    public static void main(String[] args) throws Exception {
        // Classes controladoras-base
        Staff staff = new Staff();
        Clientes clientes = new Clientes();
        Agenda agenda = new Agenda();
        Inicializador ini = new Inicializador();
        ConsultasRealizadas bancoConsultas = new ConsultasRealizadas();
        ini.iniciar(staff);
        ini.iniciar(clientes);
        ini.iniciar(agenda);
        ini.iniciar(bancoConsultas);
        // Classes entidades
        Medico medico = null;
        Paciente paciente = null;
        Agendamento agendamento = null;
        Consulta consulta = null;
        MenuPrincipal menu = new MenuPrincipal();
        // Variáveis que serão usadas em basicamente todas as entradas
        String escolha;
        String[] dados;
        int op;
        boolean verifica = true;

        // Scanners que serão utéis
        Scanner lerNum = new Scanner(System.in);
        Scanner lerStr = new Scanner(System.in);
        //
        menu.mostrarPrincipal();
        op = lerNum.nextInt();
        while (op != 5) {
            switch (op) {
                case 1:
                    menu.mostrarMedicos();
                    op = lerNum.nextInt();
                    while (op != 6) {
                        switch (op) {
                            case 1:
                                medico = new Medico();
                                System.out.print("Digite o nome: ");
                                medico.setNome(lerStr.next());
                                System.out.print("Digite a especialidade: ");
                                medico.setEspecialidade(lerStr.next());
                                System.out.print("Digite o id: ");
                                medico.setIdMedico(lerNum.nextInt());
                                staff.inserirMedico(medico);
                                break;
                            case 2:
                                System.out.print("\nDigite o id do médico que deseja alterar: ");
                                try {
                                    medico = staff.selecionaMedico(lerNum.nextInt());
                                } catch (MedicoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Esse é o médico selecionado\n" + medico
                                        + "Esse é o médico que deseja alterar?\n S ou N");
                                String escolhaAlterarMedico = lerStr.next();
                                if (escolhaAlterarMedico.equalsIgnoreCase("n")) {
                                    break;
                                }
                                System.out.print("Digite o novo nome: ");
                                medico.setNome(lerStr.next());
                                System.out.print("Digite a nova especialidade: ");
                                medico.setEspecialidade(lerStr.next());
                                staff.registrarArquivo();
                                System.out.println("Dados alterados com sucesso.");
                                break;

                            case 3:
                                System.out.print("\nDigite o id do médico que deseja remover: ");
                                try {
                                    medico = staff.selecionaMedico(lerNum.nextInt());
                                } catch (MedicoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("Esse é o médico selecionado:\n" + medico
                                        + "Esse é o médico que deseja remover?\n S ou N");
                                String escolhaRemoverMedico = lerStr.next();
                                if (escolhaRemoverMedico.equalsIgnoreCase("n")) {
                                    break;
                                }
                                staff.removerMedico(lerNum.nextInt());
                                System.out.println("\nMédico removido com sucesso.");
                                break;

                            case 4:
                                System.out.print("\nDigite o id do médico que deseja pesquisar: ");
                                try {
                                    medico = staff.selecionaMedico(lerNum.nextInt());
                                } catch (MedicoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }

                                System.out.println("Dados do médico selecionado:\n");
                                System.out.println(medico);
                                break;
                            case 5:
                                System.out.println("\nEsses são os médicos cadastrados:\n");
                                System.out.println(staff.listarMedicos());
                                break;
                            default:
                                break;
                        }
                        System.out.println();
                        menu.retornaraoMenuMedico();
                        op = lerNum.nextInt();
                    }
                    break;
                case 2:
                    menu.mostrarPacientes();
                    op = lerNum.nextInt();
                    while (op != 6) {
                        switch (op) {
                            case 1:
                                paciente = new Paciente();
                                System.out.print("Digite o nome: ");
                                paciente.setNome(lerStr.next());
                                System.out.print("Digite a idade: ");
                                paciente.setIdade(lerNum.nextInt());
                                System.out.print("Digite o sexo: ");
                                paciente.setSexo(lerStr.next());
                                System.out.print("Digite o id: ");
                                paciente.setIdPaciente(lerNum.nextInt());
                                clientes.inserirPaciente(paciente);
                                break;
                            case 2:
                                System.out.print("Digite o id do paciente que deseja alterar: ");
                                try {
                                    paciente = clientes.selecionaPaciente(lerNum.nextInt());
                                } catch (PacienteNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("Esse é o paciente selecionado\n" + medico
                                        + "Esse é o paciente que deseja alterar?\n S ou N");
                                String escolhaPacienteAlterar = lerStr.next();
                                if (escolhaPacienteAlterar.equalsIgnoreCase("n")) {
                                    break;
                                }
                                System.out.println("Esse é o paciente selecionado:\n" + paciente);
                                System.out.println();
                                System.out.print("Digite o novo nome: ");
                                paciente.setNome(lerStr.next());
                                System.out.print("Digite a nova idade: ");
                                paciente.setIdade(lerNum.nextInt());
                                System.out.print("Digite o novo sexo: ");
                                paciente.setSexo(lerStr.next());
                                staff.registrarArquivo();
                                System.out.println("Dados alterados com sucesso.");
                                break;
                            case 3:
                                System.out.print("Digite o id do paciente que deseja remover: ");
                                System.out.println("Esse é o paciente selecionado\n" + medico
                                        + "Esse é o paciente que deseja remover?\n S ou N");
                                String escolhaRemoverPaciente = lerStr.next();
                                if (escolhaRemoverPaciente.equalsIgnoreCase("n")) {
                                    break;
                                }
                                clientes.removerPaciente(lerNum.nextInt());
                                System.out.println("Paciente removido com sucesso.");

                            case 4:
                                System.out.print("Digite o id do paciente que deseja pesquisar: ");
                                try {
                                    paciente = clientes.selecionaPaciente(lerNum.nextInt());
                                } catch (PacienteNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("Dados do paciente selecionado:\n");
                                System.out.println(paciente);
                                break;
                            case 5:
                                System.out.println(clientes.listarPacientes());
                                break;
                            default:
                                System.out.println("\nOpção Inválida.");
                                break;
                        }
                        menu.mostrarPacientes();
                        op = lerNum.nextInt();
                    }
                    break;
                case 3:
                    menu.mostrarConsultas();
                    op = lerNum.nextInt();
                    while (op != 5) {
                        switch (op) {
                            case 1:
                                agendamento = new Agendamento();

                                System.out.print("Digite o id do médico para qual deseja agendar: ");
                                try {
                                    medico = staff.selecionaMedico(lerStr.nextInt());
                                } catch (MedicoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                System.out.println(
                                        "Esse é o médico selecionado\n" + medico
                                                + "Este é o médico que queria selecionar?\n \tS ou N");
                                String escolhaAgendarConsulta = lerStr.next();
                                if (escolhaAgendarConsulta.equalsIgnoreCase("n")) {
                                    break;
                                }
                                agendamento.setNomeMedico(medico.getNome());
                                agendamento.setEspecialidadeMedico(medico.getEspecialidade());

                                System.out.print("Digite o nome do paciente: ");
                                agendamento.setNomePaciente(lerStr.next());
                                System.out.println(
                                        "Informe o horário do agendamento, respeitando a máscara base: \n(dd/MM/yyyy hh:mm)");
                                lerStr.nextLine();
                                while (verifica) {
                                    dados = lerStr.nextLine().split(" ");
                                    try {
                                        agendamento.setDia(dados[0]);
                                        agendamento.setHora(dados[1]);
                                        verifica = false;
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println(
                                                "Você digitou errado o formato da máscara base.\n\nInforme o horário do agendamento, respeitando a máscara base: \n(dd/MM/yyyy hh:mm)");
                                    }
                                }
                                try {
                                    agenda.agendar(agendamento);
                                    System.out.println("Consultar marcada com sucesso");
                                } catch (AgendamentoIndisponivelException e) {
                                    System.out.println(e.getMessage());
                                    System.out.print("Deseja ir para a lista de espera do doutor(a) "
                                            + agendamento.getNomeMedico() + ", nesse horário requisitado?\n");
                                    escolha = lerStr.next();
                                    if (escolha.equalsIgnoreCase("sim")) {
                                        agenda.agendarListaEspera(agendamento);
                                        System.out.println("Consultar marcada com sucesso");
                                    }
                                }
                                break;
                            case 2:
                                agendamento = new Agendamento();
                                System.out.print("Digite o id do agendamento que deseja remover: ");
                                try {
                                    agendamento = agenda.selecionarAgendamento(lerNum.nextInt());
                                    System.out.println("Esse é o agendamento selecionado:\n" + agendamento
                                            + "\nEsse é o agendamento que você deseja cancelar?\n\tS ou N");
                                    String decida = lerStr.next();
                                    if (decida.equalsIgnoreCase("S")) {
                                        agenda.removerAgendamento(agendamento.getId());
                                        System.out.println("Consulta desmarcada com sucesso");
                                    }
                                } catch (AgendamentoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                } catch (Exception e) {
                                    System.out.println("Digite o id, que é um número, válido!");
                                }
                                break;
                            case 3:
                                agendamento = new Agendamento();
                                System.out.print("Digite o id do agendamento a ser realizado: ");
                                try {
                                    agendamento = agenda.selecionarAgendamento(lerNum.nextInt());
                                } catch (AgendamentoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                StringBuilder descricao = new StringBuilder();
                                System.out.println("Digite em uma linha, o resumo do atendimento:");
                                descricao.append(lerStr.nextLine());
                                System.out.println("Digite os sintomas do paciente, separando-os por espaço:");
                                descricao.append(lerStr.nextLine());
                                System.out.println("Digite o tratamento sugerido:");
                                descricao.append(lerStr.nextLine());
                                System.out.println("Digite possíveis medicamentos:");
                                descricao.append(lerStr.nextLine());
                                System.out.println("Digite possíveis exames");
                                descricao.append(lerStr.nextLine());
                                consulta = new Consulta(agendamento, descricao);
                                bancoConsultas.registrarConsulta(consulta);
                                break;
                            case 4:
                                System.out.println("\n1.Agendados\n2.Lista de Espera");
                                op = lerNum.nextInt();
                                switch (op) {
                                    case 1:
                                        System.out.println(agenda.listarAgendamentos());
                                        break;
                                    case 2:
                                        System.out.println(agenda.listarAgendamentosEspera());
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            default:
                                break;
                        }
                        menu.mostrarConsultas();
                        op = lerNum.nextInt();
                    }
                    break;
                case 4:

                    break;
                case 5:

                    break;

                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
            menu.mostrarPrincipal();
            op = lerNum.nextInt();
        }
    }
}
