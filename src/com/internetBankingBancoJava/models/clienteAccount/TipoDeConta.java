package com.internetBankingBancoJava.models.clienteAccount;

public enum TipoDeConta {

    CP("CONTA POUPANÇA"), CC("CONTA CORRENTE");

    private String tipoDeConta;

    TipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }
}
