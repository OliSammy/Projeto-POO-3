package paineis;

public class MenuPrincipal {
    public void mostrarPrincipal() {
        System.out.println("\nBem-Vindo à Clinica São Benedito\n");
        System.out.println("Para prosseguimos com o programa selecione uma opção abaixo:");
        System.out.println("\n1.Médicos 2.Paciente 3.Consultas 4.Relatórios 5.sair");
    }
    public void retornaraoMenuMedico(){
        System.out.println("\t\t*Você retornou ao menu dos Médicos*\n");
        System.out.println("Selecione uma opção abaixo:\n");
        System.out.println("1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    }
    public void mostrarMedicos() {
        System.out.println("\t\t*Menu Médicos selecionado*\n");
        System.out.println("Selecione uma opção abaixo:");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    }

    public void mostrarPacientes() {
        System.out.println("\t\t*Menu Pacientes selecionado*");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    }

    public void mostrarConsultas() {
        System.out.println("\t\t*Menu Agendamentos selecionado*\n");
        System.out.println("\n1.Agendar 2.Remover 3.Realizar consulta 4.Listar agendamentos 5.voltar");
    }

}
