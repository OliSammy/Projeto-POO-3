package entidades;

public class Medico {
    private String nome;
    private String especialidade;
    private int idMedico;

    // Constructo vazio pra eventuais ordenações
    public Medico() {
    }

    public Medico(String nome, String especialidade, int idMedico) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.idMedico = idMedico;
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
