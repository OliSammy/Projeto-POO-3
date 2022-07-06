package servicos;

import java.io.IOException;

import entidades.Agendamento;

public class Consulta {
    private Agendamento agendamento;
    private String descricao;

    public Consulta(Agendamento agendamento, String descricao) throws IOException {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toStringBonito() {
        return agendamento.toStringBonito() +
                "Descrição da consulta:-" + descricao + "\n";
    }

    @Override
    public String toString() {
        return agendamento.toString() +
                "Descrição da consulta:-" + descricao + "\n";
    }
}
