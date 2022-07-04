
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
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        Agendamento agendamento = new Agendamento();
        Consulta consulta = null;
        MenuPrincipal menu = new MenuPrincipal();
        // Variáveis que serão usadas em basicamente todas as entradas
        String nome, especialidade, sexo, horario, escolha;
        String[] dados;
        int id, idade, op;
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
                                System.out.print("Digite o id do médico que deseja alterar: ");
                                try {
                                    medico = staff.selecionaMedico(lerNum.nextInt());
                                } catch (MedicoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.print("Digite o novo nome: ");
                                medico.setNome(lerStr.next());
                                System.out.print("Digite a nova especialidade: ");
                                medico.setEspecialidade(lerStr.next());
                                staff.registrarArquivo();
                                System.out.println("Dados alterados com sucesso.");
                                break;
                            case 3:
                                System.out.print("Digite o id do médico que deseja remover: ");
                                staff.removerMedico(lerNum.nextInt());
                                System.out.println("Médico removido com sucesso.");
                                break;
                            case 4:
                                System.out.print("Digite o id do médico que deseja pesquisar: ");
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
                                System.out.println(staff.listarMedicos());
                                break;
                            default:
                                break;
                        }
                        menu.mostrarMedicos();
                        op = lerNum.nextInt();
                    }
                    break;
                case 2:
                    menu.mostrarPacientes();
                    op = lerNum.nextInt();
                    while (op != 6) {
                        switch (op) {
                            case 1:
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
                                clientes.removerPaciente(lerNum.nextInt());
                                System.out.println("Paciente removido com sucesso.");
                                break;
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
                                System.out.println("Opção Inválida.");
                                break;
                        }
                        menu.mostrarMedicos();
                        op = lerNum.nextInt();
                    }
                    break;
                case 3:
                    menu.mostrarConsultas();
                    op = lerNum.nextInt();
                    while (op != 5) {
                        switch (op) {
                            case 1:
                                System.out.print("Digite o id do médico para qual deseja agendar: ");
                                medico = staff.selecionaMedico(lerStr.nextInt());
                                agendamento.setNomeMedico(medico.getNome());
                                agendamento.setEspecialidadeMedico(medico.getEspecialidade());

                                System.out.print("Digite o nome do paciente: ");
                                agendamento.setNomePaciente(lerStr.next());
                                System.out.println(
                                        "Informe o horário do agendamento, respeitando a máscara base: \n(dd/MM/yyyy hh:mm)");
                                lerStr.nextLine();
                                dados = lerStr.nextLine().split(" ");
                                agendamento.setDia(dados[0]);
                                agendamento.setHora(dados[1]);
                                try {
                                    agenda.agendar(agendamento);
                                } catch (AgendamentoIndisponivelException e) {
                                    System.out.println(e.getMessage());
                                    System.out.print("Deseja ir para a lista de espera do doutor(a) "
                                            + agendamento.getNomeMedico() + ", nesse horário requisitado?");
                                    escolha = lerStr.next();
                                    if (escolha.equalsIgnoreCase("sim")) {
                                        agenda.agendarListaEspera(agendamento);
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Digite o id do agendamento que deseja remover: ");
                                agenda.removerAgendamento(lerNum.nextInt());
                                // try {

                                // } catch (Exception e) {
                                // System.out.println(e.getMessage());
                                // break;
                                // }
                                // System.out.println("Agendamento removido com sucesso.");
                                break;
                            case 3:

                                break;
                            case 4:
                                System.out.println(agenda.listarAgendamentos());
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
                    System.out.println("Opçãp inválida");
                    break;
            }
            menu.mostrarPrincipal();
            op = lerNum.nextInt();
        }
    }
}
