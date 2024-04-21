package source.com.max.jogoDaForca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class WordManager {

    public static Path PATH = Path.of("./source/words.txt");
    
    public static String random(){
        String word = "";
        String allWords = "";
        Random random = new Random();

        try {allWords = Files.readString(PATH);} catch (IOException e){};

        String[] words = allWords.split("\n");
        word = words[random.nextInt(words.length)];

        return word;
    }

    public static void printWords(){
        String allWords = "";
        try {allWords = Files.readString(PATH);} catch (IOException e){};

        System.out.println(allWords);
    }

    public static void newWord(String word){

        word = word.toLowerCase(); // se tiver acento ferrou / TO-DO: resolver isso

        String allWords = "";
        try {
            allWords = Files.readString(PATH);
            Files.writeString(PATH, allWords + word + "\n");
        } catch (IOException e) {e.printStackTrace();}
    }

    public static void deleteWord(String word){
        String allOldWords = "";
        try {allOldWords = Files.readString(PATH);} catch (IOException e){};
        String allNewWords = "";

        String[] oldWordArray = allOldWords.split("\n");
        String[] newWordArray = new String[oldWordArray.length];

        for (int i = 0; i < oldWordArray.length; i++){ // Adicionando as palavras que devem ficar, no novo array
            boolean notToDelete = !(oldWordArray[i].equals(word));

            if (notToDelete) newWordArray[i] = oldWordArray[i]; // Isso aqui deixa alguns nulls, mas não tem problema
        }

        for (String newWord : newWordArray) if (newWord != null) allNewWords += newWord + "\n";
        
        try {Files.writeString(PATH, allNewWords);} // Escrevendo no arquivo tudo novamente sem a palavra desejada
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
