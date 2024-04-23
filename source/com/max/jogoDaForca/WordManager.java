package source.com.max.jogoDaForca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordManager {

    public static Path PATH = Path.of("./source/words.txt");
    private static List<String> words = new ArrayList<>();

    static {
        try{
            words = Files.readAllLines(PATH);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static String random(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static void printWords(){
        words.forEach(System.out::println);
    }

    public static void newWord(String word){
        word = word.toLowerCase();
        words.add(word);
        saveWords();
    }

    public static void deleteWord(String word){
        words.remove(word);
        saveWords();
    }

    private static void saveWords() {
        try {
            Files.write(PATH, words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
