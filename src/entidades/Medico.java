package entidades;

import java.io.*;

public class Medico {
    private String nome;
    private String especialidade;
    private int idMedico;
    private File arquivo;

    // Constructo vazio pra eventuais ordenações
    public Medico() {
    }

    public Medico(String nome, String especialidade, int idMedico) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.idMedico = idMedico;
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Dr(a) " + nome);
            arquivo.mkdir();
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Dr(a) " + nome);
            arquivo.mkdir();
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdMedico() {
        return idMedico;
    }

    @Override
    public String toString() {
        return "Doutor(a): " + nome + "\nEspecialidade: " + especialidade + "\nId: " + idMedico + "\n";
    }
}
