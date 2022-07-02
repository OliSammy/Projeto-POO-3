package servicos;

import java.io.*;
import entidades.*;
import exceptions.MedicoJaCadastradoException;

public class Inicializador {
    private File arquivo;

    public Inicializador() {
    }

    public void iniciar(Staff staff) throws IOException, MedicoJaCadastradoException {
        if (System.getProperty("os.name").equalsIgnoreCase("windowns 11")
                || System.getProperty("os.name").equalsIgnoreCase("windowns 10")) {
            arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Staff\\staff.txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Staff/staff.txt");
        }
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorBuff = new BufferedReader(leitor);
        try {
            String[] dados = leitorBuff.readLine().split("\t");
            while (dados != null) {
                Medico x = new Medico(dados[0], dados[1], Integer.parseInt(dados[2]));
                staff.inserirMedico(x);
                dados = leitorBuff.readLine().split("\t");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            leitorBuff.close();
        }
    }
}
