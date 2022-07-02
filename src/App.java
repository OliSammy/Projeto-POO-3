import entidades.*;
import servicos.Inicializador;

public class App {
    public static void main(String[] args) throws Exception {
        Paciente paciente = new Paciente("Matheus", 24, "Masculino", 02);
        Staff staff = new Staff();
        Clientes clientes = new Clientes();
        Inicializador ini = new Inicializador();
        ini.iniciar(staff);
        ini.iniciar(clientes);
        try {
            clientes.inserirPaciente(paciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(staff.listarMedicos());
        System.out.println(clientes.listarPacientes());
    }
}
