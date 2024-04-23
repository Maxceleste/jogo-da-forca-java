package source.com.max.jogoDaForca;

import java.util.Scanner;

public class Game {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        String option = "";

        introduction();
        System.out.println("Agora, deseja adicionar/remover palavras ao jogo ou jogar?\nDigite o número das opções.");
        System.out.println("1 - Adicionar/remover palavra\n2 - Jogar\n");
        
        option = scanner.nextLine();
        scanner.close();

        if (option.equals("1")) manageWord();

        playGame();
    }

    private static void introduction(){
        System.out.println("Bem vindo ao nosso jogo da forca!\nAntes de iniciarmos, veremos as regras:\n");
        System.out.println("- Apenas letras minúsculas\n- Não possui acentos (possui 'ç')\n- Não possui números\n");
    }

    private static void manageWord(){


    }

    private static void playGame(){

        
    }

    
}
