package source.com.max.jogoDaForca;

import java.util.Scanner;

public class Game {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        String option = "";

        introduction();
        System.out.println("Agora, deseja adicionar/remover palavras ao jogo ou jogar?\nDigite o número das opções:");
        System.out.println("1 - Adicionar/remover palavra\n2 - Jogar\n");
        
        option = scanner.nextLine();

        if (option.equals("1")) manageWord();

        playGame();
        scanner.close();
    }

    private static void introduction(){
        System.out.println("Bem vindo ao nosso jogo da forca!\nAntes de iniciarmos, veremos as regras:\n");
        System.out.println("- Apenas letras minúsculas\n- Não possui acentos (possui 'ç')\n- Não possui números\n");
    }

    private static void manageWord(){
        Scanner scanner = new Scanner(System.in);
        String option = "";
        while (true){
            System.out.println("\nVocê deseja adicionar ou remover palavras?\n1 - Adicionar\n2 - Remover\n3 - Sair\n");
            option = scanner.nextLine();

            if (option.equals("1")){
                System.out.println("Digite a nova palavra que deseja Adicionar:");
                option = scanner.nextLine();
                WordManager.newWord(option);
                option = "";
            }

            if (option.equals("2")){
                System.out.println("As seguintes palavras estão presentes no jogo: \n");
                WordManager.printWords();
                System.out.println("\nDigite a palavra que deseja remover:");
                option = scanner.nextLine();
                WordManager.deleteWord(option);
                option = "";
            }

            if (option.equals("3")) break;
        }

        scanner.close();
    }

    private static void playGame(){

        
    }

    
}
