
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
        Consulta consulta;
        // Variáveis que serão usadas em basicamente todas as entradas
        String nome, especialidade, sexo, horario;
        int id, idade;
        // Scanners que serão utéis
        Scanner lerNum = new Scanner(System.in);
        Scanner lerStr = new Scanner(System.in);
        //
        medico = new Medico("Matheus", "Dentista", 01);
        staff.inserirMedico(medico);
        medico = new Medico("Samuel", "Legista", 02);
        staff.inserirMedico(medico);
        medico = new Medico("Clara", "Oftamologista", 03);
        staff.inserirMedico(medico);

        paciente = new Paciente("Eduardo", 20, "Masculino", 01);
        clientes.inserirPaciente(paciente);
        paciente = new Paciente("Alicia", 19, "Feminino", 02);
        clientes.inserirPaciente(paciente);
        paciente = new Paciente("Pedro", 18, "Masculino", 03);
        clientes.inserirPaciente(paciente);

        agendamento = new Agendamento("Matheus", "Eduardo", "Dentista", "04/07/2022 14:00");
        agenda.agendar(agendamento);
        consulta = new Consulta(agendamento, "Só um teste mesmo.");
        bancoConsultas.registrarConsulta(consulta);

        agendamento = new Agendamento("Samuel", "Alicia", "Legista", "04/07/2022 14:00");
        agenda.agendar(agendamento);
        consulta = new Consulta(agendamento, "Só um teste mesmo.");
        bancoConsultas.registrarConsulta(consulta);

        agendamento = new Agendamento("Clara", "Pedro", "Oftamologista", "04/07/2022 17:00");
        agenda.agendar(agendamento);
        consulta = new Consulta(agendamento, "Só um teste mesmo.");
        bancoConsultas.registrarConsulta(consulta);

        agendamento = new Agendamento("Clara", "Pedro", "Oftamologista", "04/07/2022 17:00");
        try {
            agenda.agendar(agendamento);
        } catch (AgendamentoIndisponivelException e) {
            System.out.println(e.getMessage());
            System.out.println("beleza?");
            String x = lerStr.next();
            agenda.agendarListaEspera(agendamento);
        }
        consulta = new Consulta(agendamento, "Só um teste mesmo.");
        bancoConsultas.registrarConsulta(consulta);

        System.out.println(staff.listarMedicos());
        System.out.println();
        System.out.println(clientes.listarPacientes());
        System.out.println();
        System.out.println(agenda.listarAgendamentos());
        System.out.println();
        System.out.println(agenda.listarAgendamentosEspera());
        System.out.println();

        agenda.removerArquivo(1);
    }
}
