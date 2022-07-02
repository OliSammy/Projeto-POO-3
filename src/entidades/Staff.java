package entidades;

import java.io.*;
import java.util.ArrayList;

import exceptions.*;

public class Staff {
    private ArrayList<Medico> staff;
    private File arquivo;

    public Staff() {
        staff = new ArrayList<Medico>();
    }

    public void inserirMedico(Medico medico) throws MedicoJaCadastradoException, IOException {
        verificaMedico(medico);
        staff.add(medico);
        registrarArquivo();
    }

    public void removerMedico(int idMedico) throws IOException {
        for (Medico medicoCadastradMedico : staff) {
            if (medicoCadastradMedico.getIdMedico() == idMedico) {
                staff.remove(medicoCadastradMedico);
                break;
            }
        }
        registrarArquivo();
    }

    public String listarMedicos() {
        StringBuilder saida = new StringBuilder();
        for (Medico medico : staff) {
            saida.append(medico.toString());
        }
        return saida.toString();
    }

    public Medico selecionaMedico(int idMedico) throws MedicoNaoEncontradoException {
        for (Medico medicoCadastradMedico : staff) {
            if (medicoCadastradMedico.getIdMedico() == idMedico) {
                return medicoCadastradMedico;
            }
        }
        throw new MedicoNaoEncontradoException();
    }

    public void verificaMedico(Medico medico) throws MedicoJaCadastradoException {
        for (Medico medicoCadastrado : staff) {
            if (medicoCadastrado.getIdMedico() == medico.getIdMedico()) {
                throw new MedicoJaCadastradoException();
            }
        }
    }

    // Inserir no arquivo dos Medicos
    public void registrarArquivo() throws IOException {
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Staff\\staff.txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Staff/staff.txt");
        }
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter escritorBuff = new BufferedWriter(escritor);
        for (Medico medico : staff) {
            escritorBuff
                    .write(medico.getNome() + "-" + medico.getEspecialidade() + "-" + medico.getIdMedico() + "\n");
        }
        escritorBuff.close();
    }

    public void setStaff(ArrayList<Medico> staff) {
        this.staff = staff;
    }

    public ArrayList<Medico> getStaff() {
        return staff;
    }
}
