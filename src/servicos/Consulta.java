package servicos;

import java.io.IOException;

import entidades.Agendamento;

public class Consulta {
    private Agendamento agendamento;
    private StringBuilder descricao;

    public Consulta(Agendamento agendamento, StringBuilder descricao) throws IOException {
        this.agendamento = agendamento;
        this.descricao = descricao;
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

    public String toStringBonito() {
        return agendamento.toStringBonito() +
                "Descrição da consulta:\n" + descricao.toString();
    }

    @Override
    public String toString() {
        return agendamento.toString() +
                "Descrição da consulta:\n" + descricao.toString();
    }
}
