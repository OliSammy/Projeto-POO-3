package servicos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entidades.Agendamento;

public class Consulta {
    private Agendamento agendamento;
    private StringBuilder descricao;
    private String data;
    private String hora;

    public Consulta(Agendamento agendamento, StringBuilder descricao) throws IOException {
        this.agendamento = agendamento;
        this.descricao = descricao;
        Date dataHoraAtual = new Date();
        data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        hora = new SimpleDateFormat("hh:mm").format(dataHoraAtual);
    }

    public void setId(int id) {
        agendamento.setId(id);
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public StringBuilder getDescricao() {
        return descricao;
    }

    public void setDescricao(StringBuilder descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String toStringBonito() {
        return agendamento.toStringBonito() +
                "Data e hora da realização da consulta:-" + data + " " + hora +
                "\nDescrição da consulta:-" + descricao.toString() + "\n";
    }

    @Override
    public String toString() {
        return agendamento.toString() +
                "Data e hora da realização da consulta:-" + data + " " + hora +
                "\nDescrição da consulta:-" + descricao.toString() + "\n";
    }
}
