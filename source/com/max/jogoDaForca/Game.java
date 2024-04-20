package source.com.max.jogoDaForca;

public class Game {
    public static void run(){

        introduction();
        System.out.println("Agora, deseja adicionar novas palavras ao jogo ou jogar?\nDigite o número das opções.");
        System.out.println("1 - Adicionar nova palavra\n2 - Jogar");


    }

    public static void introduction(){
        System.out.println("Bem vindo ao nosso jogo da forca!\nAntes de iniciarmos, veremos as regras:\n");
        System.out.println("- Apenas letras minúsculas\n- Não possui acentos (possui 'ç')\n- Não possui números\n");
    }

    
}
