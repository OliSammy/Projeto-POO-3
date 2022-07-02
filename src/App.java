import entidades.*;
import servicos.Inicializador;

public class App {
    public static void main(String[] args) throws Exception {
        Medico doutor = new Medico("Matheus", "Dentista", 2);
        Medico doutor2 = new Medico("Clara", "Oftamologista", 3);
        Medico doutor3 = new Medico("Samuel", "Urologista", 4);
        // Paciente paciente = new Paciente("Samuel", 18, "Masculino", 01);
        Staff staff = new Staff();
        Inicializador ini = new Inicializador();
        ini.iniciar(staff);
        System.out.println(staff.listarMedicos());
    }
}
