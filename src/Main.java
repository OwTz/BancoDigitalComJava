import java.util.Locale;
import java.util.Scanner;
import com.internetBankingBancoJava.models.services.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        boolean ativo = true ;

        while ( ativo){
            try {

                System.out.printf(String.format("digite a opção desejada : \n ? \n ? \n ? ","verificar","criar","teste"));
                Integer opcaoUsuario = scan.nextInt();

                switch (opcaoUsuario){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }

            } catch (listaVaziaException e){
                new listaVaziaException("opcao inválida");
                return;
            }

        }

    }
}