import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.InputMismatchException;

public class Main {
    public static void main (String[] args){
        Scanner yan = new Scanner(System.in);
        
        boolean executando = true;
        
        while(executando){
            System.out.println("1 - cadastrar");
            System.out.println("2 - listar");
            System.out.println("3 - alterar");
            System.out.println("4 - deletar");
            System.out.println("5 - sair");
            
            int opcao = yan.nextInt();
            yan.nextLine();
            
            switch(opcao) {
    // Cadastrar
            case 1:
                try {
                FileWriter arquivo = new FileWriter("dados.txt", true);
                String nome = yan.nextLine();
                int idade = yan.nextInt();
                arquivo.write(nome + "\n");
                arquivo.write("Idade; " + idade + "\n");
        
                arquivo.close();
    // Proteção anti erros    
                } catch (IOException e) {
                System.out.println("Erro");
                } catch (InputMismatchException a) {
                System.out.println("Eu pedi um número, não uma letra. Seu buxa");
                }
                yan.close();
                break;
    // Listar
            case 2:
                try{
                File arquivo = new File("dados.txt");
                Scanner listor = new Scanner(arquivo);
                
                    while (listor.hasNextLine()) {
                    String linha = listor.nextLine();
                    
                    System.out.println(linha);
                    }
                listor.close();
                } catch (IOException e) {
                System.out.println("Erro");
                } catch (InputMismatchException a) {
                System.out.println("Formato errado. Seu buxa");
                }
                yan.close();
                break;
    // Sair
            case 3:
                executando = false;
                break;
            }
        }
    }
}
