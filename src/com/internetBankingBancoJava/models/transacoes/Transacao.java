package com.internetBankingBancoJava.models.transacoes;

import org.w3c.dom.CDATASection;

import java.time.LocalDate;
import java.util.Objects;

public class Transacao {

    private String codigo;
    private LocalDate data;
    private float valor;

    public Transacao(String codigo, LocalDate date , float valor){

        this.codigo = codigo;
        this.data = data;
        this.valor = valor;

    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(codigo, transacao.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "\n Transacao date: "+this.getData()+
                "\n Transação Code: " +this.getCodigo()+
                "\n  transcao valor: "+this.getValor();
    }
}
