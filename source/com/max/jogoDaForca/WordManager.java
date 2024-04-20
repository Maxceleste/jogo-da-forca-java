package source.com.max.jogoDaForca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordManager {
    
    public static String random(){
        String word = "";
        String s = "";

        Path path = Path.of("./source/words.txt");

        try {
            s = Files.readString(path);
        } catch (IOException e){};

        System.out.println(s);

        return word;
    }

}
