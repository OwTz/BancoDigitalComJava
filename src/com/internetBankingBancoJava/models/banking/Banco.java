package com.internetBankingBancoJava.models.banking;
import com.internetBankingBancoJava.models.services.*;
import com.internetBankingBancoJava.models.clienteAccount.ClienteActions;
import com.internetBankingBancoJava.models.clienteAccount.ContaCliente;
import com.internetBankingBancoJava.models.clienteAccount.TipoDeConta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Banco implements ClienteActions
{

    String nome;
    int agencia;
    int SEQUENCIA = 1;
    Map<Integer, ContaCliente> listaDeClientes;

    public Banco(String nome){
        this.listaDeClientes = new HashMap<>();
        this.nome = nome;
        this.agencia = 1235;
    }
    @Override
    public void saque(float valor) {

    }

    @Override
    public void deposito(float valor) {

    }

    public void adicionarCliente(String nome, TipoDeConta tipo )
    {
        int numeroDAC = this.SEQUENCIA++;

        try{

            this.listaDeClientes.put(numeroDAC, new ContaCliente(nome,this.agencia,numeroDAC,tipo));
            System.out.println("cliente adicionador! ");

        } catch (NullPointerException n){
            System.out.println( new NullPointerException("usuário invválido").getMessage());
        } catch (RuntimeException b){
            new NullPointerException( new NullPointerException("usuário invválido").getMessage());
        }

    }


    public Map exibirListaDeUsuario(){
        Map<Integer, ContaCliente> listaDeUsuario = null;
            if (! this.listaDeClientes.isEmpty()){
                listaDeUsuario = this.listaDeClientes;
            }
        return  listaDeUsuario;
    }

    public void clientesDoBanco(Map listaDeClientes){
        try {
            listaDeClientes.values()
                    .stream().
                    forEach(System.out::println);
            System.out.println();
        } catch (listaVaziaException n){
            System.out.println(new listaVaziaException("a lista está vazia"));
        }
    }

}
