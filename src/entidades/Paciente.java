package entidades;

public class Paciente {
    private String nome;
    private int idade;
    private String sexo;
    private int idPaciente;

    public Paciente() {
    }

    public Paciente(String nome, int idade, String sexo, int idPaciente) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade + "\nId: " + idPaciente + "\n";
    }
}
