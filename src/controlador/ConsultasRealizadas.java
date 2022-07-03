package controlador;

import java.io.*;
import java.util.ArrayList;

import servicos.Consulta;

public class ConsultasRealizadas {
    private File arquivo;
    private ArrayList<Consulta> bancoConsultas;

    public ConsultasRealizadas() {
        bancoConsultas = new ArrayList<Consulta>();
    }

    public void registrarConsulta(Consulta consulta) throws IOException {
        bancoConsultas.add(consulta);
        gerarArquivos();
    }

    public String listarConsultas() {
        StringBuilder saida = new StringBuilder();
        for (Consulta consultas : bancoConsultas) {
            saida.append(consultas.toStringBonito());
        }
        return saida.toString();
    }

    public void gerarArquivos() throws IOException {
        for (Consulta consulta : bancoConsultas) {
            if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                    || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
                arquivo = new File(
                        "C:\\workspace\\Projeto3-POO\\Consultas Realizadas\\Id: " + consulta.getAgendamento().getId()
                                + ".txt");
            } else {
                arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Consultas Realizadas/Id: "
                        + consulta.getAgendamento().getId() + ".txt");
            }
            BufferedWriter escritorBuff = new BufferedWriter(new FileWriter(arquivo));
            escritorBuff.write(consulta.toString());
            escritorBuff.close();
        }

    }

    public ArrayList<Consulta> getBancoConsultas() {
        return bancoConsultas;
    }

    public void setBancoConsultas(ArrayList<Consulta> bancoConsultas) {
        this.bancoConsultas = bancoConsultas;
    }

}
