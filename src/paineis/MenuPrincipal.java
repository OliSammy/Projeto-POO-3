package paineis;

public class MenuPrincipal {
    public void mostrarPrincipal() {
        System.out.println("\t\tSistema de Clinica");
        System.out.println("Selecione uma das opções:");
        System.out.println("\n1.Médicos 2.Paciente 3.Consultas 4.Relatórios 5.sair");
    }

    public void mostrarMedicos() {
        System.out.println("\t\tMenu Médicos selecionado");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    }

    public void mostrarPacientes() {
        System.out.println("\t\tMenu Pacientes selecionado");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    }

    public void mostrarConsultas() {
        System.out.println("\t\tMenu Agendamentos selecionado");
        System.out.println("\n1.Agendar 2.Remover 3.Realizar consulta 4.Listar agendamentos 5.voltar");
    }

}
