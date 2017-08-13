import com.sun.speech.freetts.en.us.CMULexicon;
import com.sun.speech.freetts.lexicon.Lexicon;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        Lexicon lex = CMULexicon.getInstance(true);
        String[] phones = lex.getPhones("bat", "n");
        for(String s : phones){
            System.out.println(s);
        }
    }
}