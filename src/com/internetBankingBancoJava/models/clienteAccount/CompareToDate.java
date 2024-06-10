package com.internetBankingBancoJava.models.clienteAccount;

import com.internetBankingBancoJava.models.transacoes.Transacao;

import java.time.LocalDate;
import java.util.Comparator;


public class CompareToDate implements Comparator<Transacao> {
    @Override
    public int compare(Transacao p1, Transacao p2) {
        LocalDate data1 = p1.getData();
        LocalDate data2 = p2.getData();
        return data1.compareTo(data2);
    }
}
