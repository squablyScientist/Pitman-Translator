import com.sun.speech.freetts.en.us.CMULexicon;
import com.sun.speech.freetts.lexicon.Lexicon;

import java.io.IOException;
public class TextProc {


    /**
     * Splits a bunch of words into an array of a bunch of words
     *
     * @param s The string of multiple words which will be split into an array of each word
     * @return An array of strings, each one word of the string s
     */
    public static String[] wordsSplit(String s) {
        return s.split("\\s");
    }

    /**
     * Grabs the phones for a word
     *
     * @param s A word
     * @return An array of phones that correspond to the word given in String s
     * @throws IOException
     */
    public static String[] getWordPhones(String s) throws IOException {
        Lexicon lex = CMULexicon.getInstance(true);
        return lex.getPhones(s.toLowerCase(), "n");
    }

    /**
     * Entire string to phone arrays
     *
     * @param s Any string
     * @return An array of arrays that hold the phones for all words within String s
     */
    public static String[][] phones(String s) {
        String[] words = wordsSplit(s);
        String[][] phones = new String[s.length()][];

        for (int i = 0; i < phones.length; i++) {
            try {
                phones[i] = getWordPhones(words[i]);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return phones;
    }
}
