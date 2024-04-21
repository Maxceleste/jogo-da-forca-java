package source.com.max.jogoDaForca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class WordManager {
    
    public static String random(){
        String word = "";
        String allWords = "";
        Random random = new Random();

        Path path = Path.of("./source/words.txt");

        try {allWords = Files.readString(path);} catch (IOException e){};

        String[] words = allWords.split("\n");
        word = words[random.nextInt(words.length)];

        return word;
    }

    public static void printWords(){
        String allWords = "";
        Path path = Path.of("./source/words.txt");
        try {allWords = Files.readString(path);} catch (IOException e){};

        System.out.println(allWords);
    }

    public static void newWord(String word){

        word = word.toLowerCase(); // se tiver acento ferrou / TO-DO: resolver isso

        Path path = Path.of("./source/words.txt");
        String allWords = "";
        try {
            allWords = Files.readString(path);
            Files.writeString(path, allWords + word + "\n");
        } catch (IOException e) {e.printStackTrace();}
    }

    //TO-DO: delete word method

}
