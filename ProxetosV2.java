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
                cadastrar(yan);
                break;
    // Listar
            case 2:
                listar();
                break;
    // Alternar (Não feito)
            case 3:
                System.out.println("Erro 404");
                break;
    // Deletar (não feito)
            case 4:
                System.out.println("Erro 404.2");
                break;
    // Sair
            case 5:
                executando = false;
                break;
            }
            
        }
        yan.close();
    }

public static void cadastrar(Scanner yan){
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
                
}
public static void listar(){
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
                } 
}
}
}
