package com.internetBankingBancoJava.models.clienteAccount;

import com.internetBankingBancoJava.models.transacoes.Transacao;

import java.util.*;
import java.time.LocalDate;

public  class  ContaCliente implements  ClienteActions{

/*
@todo argumentos da classe
 */
    private String nome;
    private long conta;
    private int agencia;
    private float saldo;
    private Map<String, Transacao> transacoes ;
    private final TipoDeConta tipodeConta;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getConta() {
        return this.conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Map getTransacoes() {
        return this.transacoes;
    }

    public ContaCliente(String nome, int agencia, long numeroConta,TipoDeConta tipo){

        this.transacoes = new HashMap<>();
        this.setSaldo(0);
        this.setConta(numeroConta);
        this.setAgencia(agencia);
        this.setNome(nome);
        this.tipodeConta = tipo;

    }

    /*
        @Todo interface de Saque
     */

    @Override
    public void saque(float valor) {

        LocalDate data = LocalDate.now();

        if (this.getSaldo() > valor ) {
            String codigoTransacao = this.gerarCodigoAleatorio();
            transacoes.put(codigoTransacao, new Transacao(codigoTransacao,data, valor));
            this.setSaldo(this.getSaldo() - valor);

        } else {
            System.out.println("ação não completada");
        }

    }

    @Override
    public void deposito(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }
    /*
        @param equals cada usuário cadastrado não poded conter o mesmo codigo de conta
         @todo numero da conta não pode ser répetido ao criar um usuário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCliente that = (ContaCliente) o;
        return conta == that.conta;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(conta);
    }

    public String gerarCodigoAleatorio(){
        String codigo = null;
        String setOfCharacters = "abcdefghxyz1234567-/@";
        int randomInt = new Random().nextInt(setOfCharacters.length());
        codigo ="c" +new Random().nextInt(999999) + new Random().nextInt(randomInt);
        System.out.println(codigo);
        return codigo;
    }

    public void exibirTransacao() {

        for (Transacao t : this.transacoes.values()) {
            System.out.println("Transacaot" + t.getCodigo() +
                    "\n data: " + t.getData() + "\n valor: " + t.getValor());
        }

    }

    public List searchTransaction(LocalDate date){
        List transacoes = null;
        if (! this.transacoes.isEmpty()){
            for(Transacao t: this.transacoes.values()){
                if (t.getData() == date){
                    Transacao transacao = this.transacoes.get(date);
                    transacoes.add(transacao);
                }
            }

        } else {
            System.out.println("sem transações na conta ");
        }

        return transacoes;
    }

    public void reotornarTransacoes(List lista) {
        lista.stream().forEach(System.out::println);
    }
    public void enviarTransferencia(ContaCliente conta, float valor){
        LocalDate data = LocalDate.now();
       String codigoTransacao = this.gerarCodigoAleatorio();

        this.transacoes.put(codigoTransacao,new Transacao(codigoTransacao,data,valor));

        this.setSaldo(this.getSaldo() - valor);
        conta.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public String toString() {
        return "=== Conta Cliente ===" +
                "nome:'" + nome + '\'' +
                ", conta:" + conta +
                ", agencia: " + agencia +
                ", saldo: " + saldo +
                ", tipodeConta: '" + tipodeConta + '\'' ;
    }


}
