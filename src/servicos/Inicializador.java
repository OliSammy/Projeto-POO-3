package servicos;

import java.io.*;
import java.text.ParseException;

import controlador.*;
import exceptions.*;
import entidades.*;

public class Inicializador {
    private File arquivo;

    public void iniciar(Staff staff) throws IOException, MedicoJaCadastradoException {
        String linha = new String();
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Staff\\staff.txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Staff/staff.txt");
        }
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorBuff = new BufferedReader(leitor);
        linha = leitorBuff.readLine();
        while (true) {

            if (linha == null) {
                break;
            }
            String[] dados = linha.split("-");
            int id = Integer.parseInt(dados[2]);
            Medico x = new Medico(dados[0], dados[1], id);
            staff.inserirMedico(x);
            linha = leitorBuff.readLine();
        }
        leitorBuff.close();
    }

    public void iniciar(Clientes clientes) throws IOException, PacienteJaCadastradoException {
        String linha = new String();
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Pacientes\\pacientes.txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Pacientes/pacientes.txt");
        }
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorBuff = new BufferedReader(leitor);
        linha = leitorBuff.readLine();
        while (true) {

            if (linha == null) {
                break;
            }
            String[] dados = linha.split("-");
            int idade = Integer.parseInt(dados[1]);
            int id = Integer.parseInt(dados[3]);

            Paciente x = new Paciente(dados[0], idade, dados[2], id);
            clientes.inserirPaciente(x);
            linha = leitorBuff.readLine();
        }
        leitorBuff.close();
    }

    public void iniciar(Agenda agenda)
            throws IOException, ParseException, AgendamentoIndisponivelException {
        String linha = "";
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Agendamentos\\");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Agendamentos/");
        }
        for (File agendamentos : arquivo.listFiles()) {
            String[] dados;
            String[] dadosExtraidos = new String[5];
            BufferedReader leitorBuff = new BufferedReader(new FileReader(agendamentos));
            int i = 0;
            while (true) {
                linha = leitorBuff.readLine();
                if (linha == null) {
                    break;
                }
                dados = linha.split("-");
                dadosExtraidos[i] = dados[1];
                i++;
            }
            String[] dataHora = dadosExtraidos[4].split(" ");
            Agendamento temp = new Agendamento(Integer.parseInt(
                    dadosExtraidos[0]), dadosExtraidos[1], dadosExtraidos[2], dadosExtraidos[3], dataHora[0],
                    dataHora[1]);
            agenda.agendar(temp);

            leitorBuff.close();
        }
        linha = "";
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\(ListaEspera)Agendamentos\\");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/(ListaEspera)Agendamentos/");
        }
        for (File agendamentos : arquivo.listFiles()) {
            String[] dados;
            String[] dadosExtraidos = new String[5];
            BufferedReader leitorBuff = new BufferedReader(new FileReader(agendamentos));
            int i = 0;
            while (true) {
                linha = leitorBuff.readLine();
                if (linha == null) {
                    break;
                }
                dados = linha.split("-");
                dadosExtraidos[i] = dados[1];
                i++;
            }
            String[] dataHora = dadosExtraidos[4].split(" ");
            Agendamento temp = new Agendamento(Integer.parseInt(
                    dadosExtraidos[0]), dadosExtraidos[1], dadosExtraidos[2], dadosExtraidos[3], dataHora[0],
                    dataHora[1]);
            agenda.agendarListaEspera(temp);

            leitorBuff.close();
        }
    }

    public void iniciar(ConsultasRealizadas bancoConsultas) throws IOException {
        String linha = "";
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Consultas Realizadas\\");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Consultas Realizadas/");
        }
        for (File agendamentos : arquivo.listFiles()) {
            String[] dados;
            String[] dadosExtraidos = new String[7];
            BufferedReader leitorBuff = new BufferedReader(new FileReader(agendamentos.getAbsolutePath()));
            int i = 0;
            while (true) {
                linha = leitorBuff.readLine();
                if (linha == null) {
                    break;
                }
                dados = linha.split("-");
                dadosExtraidos[i] = dados[1];
                i++;
            }
            Consulta temp = new Consulta(
                    new Agendamento(Integer.parseInt(dadosExtraidos[0]), dadosExtraidos[1], dadosExtraidos[2],
                            dadosExtraidos[3], dadosExtraidos[4],
                            dadosExtraidos[5]),
                    dadosExtraidos[6]);
            temp.setDescricao(dadosExtraidos[6]);
            bancoConsultas.registrarConsulta(temp);

            leitorBuff.close();
        }
    }
}
