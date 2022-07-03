
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import controlador.Agenda;
import entidades.*;
import servicos.Inicializador;

public class App {
    public static void main(String[] args) throws Exception {
        Medico doutor = new Medico("Dede", "Tudo", 3);
        Paciente paciente = new Paciente("Matheus", 24, "Masculino", 3);
        Staff staff = new Staff();
        Clientes clientes = new Clientes();
        Inicializador ini = new Inicializador();
        try {
            ini.iniciar(staff);
            ini.iniciar(clientes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            clientes.inserirPaciente(paciente);
            staff.inserirMedico(doutor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(staff.listarMedicos());
        System.out.println(clientes.listarPacientes());
        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date horario = mascara.parse("03/07/2022 14:00");

        Agendamento teste = new Agendamento(doutor, paciente, horario);
        Agenda agenda = new Agenda();
        try {
            agenda.agendar(teste);
            System.out.println("Conseguiu");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
