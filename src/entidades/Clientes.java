package entidades;

import java.util.ArrayList;

import exceptions.*;

import java.io.*;

public class Clientes {
    private ArrayList<Paciente> clientes;
    private File arquivo;

    public Clientes() {
        clientes = new ArrayList<Paciente>();
    }

    public void inserirPaciente(Paciente paciente) throws PacienteJaCadastradoException, IOException {
        verificaPaciente(paciente);
        clientes.add(paciente);
        registrarArquivo();
    }

    public void removerPaciente(int idPaciente) throws IOException {
        for (Paciente clientesCadastrado : clientes) {
            if (clientesCadastrado.getIdPaciente() == idPaciente) {
                clientes.remove(clientesCadastrado);
                break;
            }
        }
        registrarArquivo();
    }

    public String listarPacientes() {
        StringBuilder saida = new StringBuilder();
        for (Paciente paciente : clientes) {
            saida.append(paciente.toString());
        }
        return saida.toString();
    }

    public Paciente selecionaPaciente(int idPaciente) throws PacienteNaoEncontradoException {
        for (Paciente pacienteCadastrado : clientes) {
            if (pacienteCadastrado.getIdPaciente() == idPaciente) {
                return pacienteCadastrado;
            }
        }
        throw new PacienteNaoEncontradoException();
    }

    public void verificaPaciente(Paciente paciente) throws PacienteJaCadastradoException {
        for (Paciente pacienteCadastrado : clientes) {
            if (pacienteCadastrado.getIdPaciente() == paciente.getIdPaciente()) {
                throw new PacienteJaCadastradoException();
            }
        }
    }

    // Inserir no arquivo dos Medicos
    public void registrarArquivo() throws IOException {
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Pacientes\\pacientes.txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Pacientes/pacientes.txt");
        }
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter escritorBuff = new BufferedWriter(escritor);
        for (Paciente paciente : clientes) {
            escritorBuff
                    .write(paciente.getNome() + "-" + paciente.getIdade() + "-" + paciente.getSexo() + "-"
                            + paciente.getIdPaciente() + "\n");
        }
        escritorBuff.close();
    }
}
