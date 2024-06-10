package com.internetBankingBancoJava;

import com.internetBankingBancoJava.models.banking.Banco;
import com.internetBankingBancoJava.models.clienteAccount.ContaCliente;
import com.internetBankingBancoJava.models.clienteAccount.TipoDeConta;
import com.internetBankingBancoJava.models.services.*;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        Boolean ativo=true;

        Banco banco = new Banco("OWtz.ltda");

        try {
           while (ativo == true){
              int opc = menuInterface();
              switch (opc){
                  case 1:
                      System.out.println("Digite o nome do Cliente: ");
                      String nome = scan.nextLine();
                      System.out.println("digite CP para Conta poupança \n CC para Conta Corrente : ");
                      String resultado = scan.nextLine();

                        if (resultado.toLowerCase().equals("cc"))
                            banco.adicionarCliente(nome, TipoDeConta.CC);
                        else if(resultado.toLowerCase().equals("cp"))
                            banco.adicionarCliente(nome, TipoDeConta.CP);
                        else
                            System.out.println("erro, tipo de conta não encontrado");

                      break;
                  case 2:

                      try {
                          System.out.println("exibindo lista de clientes");
                          Map listaDeClientes = banco.exibirListaDeUsuario();
                          banco.clientesDoBanco(listaDeClientes);
                      } catch (listaVaziaException  n){
                          System.out.println(new listaVaziaException("lista vazia"));
                      }


                      break;
                  case 3:
                      System.out.println("Finalizando aplicação ");
                      ativo = false;

                      break;
              }
           }

        } catch (NumberFormatException n){
          String erroCatch = n.getMessage();
          System.out.println(new NullPointerException("erro, valor inválido").getMessage());
        }

    }

    public static Integer menuInterface(){
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.printf(String.format("digite a opção desejada : \n 1 - %s \n 2 - %s \n 3 - %s \n","Adicionar Cliente","Ver Lista De Clientes","Finalizar aplicação"));
        int opc =  Integer.parseInt(scan.next());
        return opc;
    }
}
