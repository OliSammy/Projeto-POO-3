
import java.util.Scanner;

import controlador.*;
import entidades.*;
import exceptions.*;
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
        Medico medico;
        Paciente paciente;
        Agendamento agendamento;
        // Variáveis que serão usadas em basicamente todas as entradas
        String nome, especialidade, sexo, horario;
        int id, idade;
        // Scanners que serão utéis
        Scanner lerNum = new Scanner(System.in);
        Scanner lerStr = new Scanner(System.in);
        //
        // Consulta teste = new Consulta(agendamento, "Nada foi feito. Teste dois.");
        // bancoConsultas.registrarConsulta(teste);
        // agendamento = new Agendamento("Matheus", "Julio", "Dentista",
        // "03/07/2022 14:00");
        // try {
        // agenda.agendar(agendamento);
        // } catch (AgendamentoIndisponivelException e) {
        // System.out.println(e.getMessage());
        // System.out.println("Deseja entrar na lista de espera?");
        // String escolha = lerStr.next();
        // if (escolha.equalsIgnoreCase("sim")) {
        // agenda.agendarListaEspera(agendamento);
        // } else {
        // System.out.println("Obrigado e até a próxima.");
        // }
        // }
        System.out.println(agenda.listarAgendamentos());
        System.out.println(agenda.listarAgendamentosEspera());
    }
}
