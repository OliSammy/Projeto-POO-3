
import controlador.Agenda;
import controlador.Clientes;
import controlador.Staff;
import entidades.*;
import servicos.Inicializador;

public class App {
    public static void main(String[] args) throws Exception {
        Staff staff = new Staff();
        Clientes clientes = new Clientes();
        Agenda agenda = new Agenda();
        Inicializador ini = new Inicializador();
        ini.iniciar(staff);
        ini.iniciar(clientes);
        ini.iniciar(agenda);
        System.out.println(agenda.listarAgendamentos());
        agenda.agendar(new Agendamento("Julio", "Matheus", "Pulmonar", "03/07/2022 15:00"));
        System.out.println(agenda.listarAgendamentos());
    }
}
