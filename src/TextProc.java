//TODO add documentation
import com.sun.speech.freetts.en.us.CMULexicon;
import com.sun.speech.freetts.lexicon.Lexicon;

import java.io.IOException;

public class TextProc {
    public static String[] wordsSplit(String s){
        return s.split("\\s");
    }

    public static String[] getWordPhones(String s) throws IOException{
        Lexicon lex = CMULexicon.getInstance(true);
        return lex.getPhones(s.toLowerCase(), "n");
    }

    public static String[][] phones(String s){
        String[] words = wordsSplit(s);
        String[][] phones = new String[s.length()][];

        for(int i = 0; i < phones.length; i++){
            try {
                phones[i] = getWordPhones(words[i]);
            }
            catch(IOException e){
                e.printStackTrace();

            }
        }
        return phones;
    }
}
