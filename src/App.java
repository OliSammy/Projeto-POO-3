import entidades.*;

public class App {
    public static void main(String[] args) throws Exception {
        Medico doutor2 = new Medico("Clara", "Oftamologista", 3);
        Medico doutor3 = new Medico("Samuel", "Urologista", 4);
        // Paciente paciente = new Paciente("Samuel", 18, "Masculino", 01);
        Staff staff = new Staff();
        staff.iniciar();
        System.out.println(staff.listarMedicos());
        staff.removerMedico(18);
        System.out.println(staff.listarMedicos());
    }
}
