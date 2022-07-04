
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
        String nome, especialidade, sexo, horario;
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
                                }
                                System.out.println("Dados do médico selecionado:\n");
                                System.out.println(medico);
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
                    break;
                case 3:
                    menu.mostrarConsultas();
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
