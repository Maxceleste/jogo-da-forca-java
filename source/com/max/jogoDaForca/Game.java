package source.com.max.jogoDaForca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static Scanner scanner = new Scanner(System.in);

    public static void run(){
        String option = "";
        introduction();
        do {
            System.out.println("\nAgora, deseja adicionar/remover palavras ao jogo ou jogar?\nDigite o número das opções:");
            System.out.println("1 - Adicionar/remover palavra\n2 - Jogar\n3 - Sair");
            
            option = scanner.nextLine();

            if (option.equals("1")) {
                manageWord();
            } else if (option.equals("2")) {
                playGame();
            } else if (!option.equals("3")) {
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (!option.equals("3"));

        scanner.close();
    }

    private static void introduction(){
        System.out.println("Bem vindo ao nosso jogo da forca!\nAntes de iniciarmos, veremos as regras:\n");
        System.out.println("- Apenas letras minúsculas\n- Não possui acentos (possui 'ç')\n- Não possui números\n");
    }

    private static void manageWord(){
        String option = "";
        while (true){
            System.out.println("\nVocê deseja adicionar ou remover palavras?\n1 - Adicionar\n2 - Remover\n3 - Sair\n");
            option = scanner.nextLine();

            if (option.equals("1")){
                System.out.println("As seguintes palavras estão presentes no jogo: \n");
                WordManager.printWords();
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
    }

    private static void printWord (String[] word){
        for (String character : word){
            System.out.print(character);
        }
    }

    private static void playGame(){
        String[] word = (WordManager.random()).split(""); // array das letras
        String[] hiddenWord = new String[word.length]; // array das letras para o jogador descobrir
        for (int i = 0; i < hiddenWord.length; i++) hiddenWord[i] = "_"; 
        boolean isRunning = true;
        List<String> triedChars = new ArrayList<>(); // Lista das letras tentadas
        int tries = 6; // Pontos de vida
        int points = 0; // Pontos para ganhar se for igual ao tamanho da palavra

        System.out.println("Vamos agora ao jogo da forca!");

        while(isRunning){

            String guess = " ";
            boolean rigthGuess = false;

            System.out.print("Palpites: ");
            for (String character : triedChars){
                System.out.print(character + " ");
            }
            System.out.println("");

            System.out.println("Tentativas restantes: " + tries + "\n");

            printWord(hiddenWord);

            System.out.println("\n\n Dê o seu palpite de letra:");
            guess = scanner.nextLine();

            for (int i = 0; i < word.length ; i++){ // Checando se a letra está na palavra e substituindo os _
                if (guess.equals(word[i]) && !(guess.equals(hiddenWord[i]))){ //Está na palavra e não foi tentado
                    rigthGuess = true;
                    hiddenWord[i] = guess;
                    points++; 
                }
            }

            triedChars.add(guess);

            if (!rigthGuess){
                System.out.println("Errou uma letra! -1 tentativa.");
                tries--;
            }else{
                System.out.println("Acertou uma letra!");
            }

            if (points == hiddenWord.length){
                System.out.println("Parabéns você acertou todas as letras!");
                System.out.print("A palavra era: ");
                printWord(word);
                System.out.println(""); // Só pra pular linha
                isRunning = false;
            }

            if (tries == 0){
                System.out.println("Sinto muito, você perdeu.");
                System.out.print("A palavra era: ");
                printWord(word);
                System.out.println(""); // Só pra pular linha
                isRunning = false;
            }
        }        
    }    
}
