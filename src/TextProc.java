import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextProc {

    //Path to CMULexicon dictionary
    private static final String LEXICONPATH = "C:\\Users\\squab\\IdeaProjects\\Pitman-Translator\\src\\strokeFiles\\cmudict-0.7b.txt";
    static Map<String, List<String>> lexicon;
    static Map<String, Character> pitmanLex;

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
     * Grabs the phones of a word from lexicon hashmap, which is populated by the words withing the CMULexicon
     * @param s A word that should be in the CMULexicon
     * @return an array of strings that hold the phones for the word in String s
     * @throws IllegalArgumentException If the word given is not in the CXMULexicon, then an illegeal argument exception is thrown
     */
    static String[] getWordPhones(String s) throws IllegalArgumentException{
        List<String> phoneList;
        if((phoneList = lexicon.get(s.toUpperCase())) != null){
            return phoneList.toArray(new String[phoneList.size()]);
        }
        throw new IllegalArgumentException("Not in lexicon");

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
            } catch (IllegalArgumentException e) {
                e.printStackTrace();

            }
        }
        return phones;
    }

    /**
     * Runtime loading of lexicon mappings
     */
    public static void load(){
        lexicon = new HashMap<>(133910);
        BufferedReader br;
        FileReader fr;

        try{
            fr = new FileReader(LEXICONPATH);
            br = new BufferedReader(fr);

            //get past cmu copyright stuff
            for(int i = 0; i < 56; i++){
                br.readLine();
            }

            String line;
            while((line = br.readLine()) != null){
                mapLex(line);
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Maps a word to its correct phones based on one line of the CMU lexicon
     * @param s String of a word and its phones to be mapped to eachother
     */
    private static void mapLex(String s){

        Scanner sc = new Scanner(s);
        List<String> phones = new ArrayList<>();
        String word = sc.next();
        while(sc.hasNext()){
            phones.add(sc.next());
        }
        lexicon.put(word, phones);
        System.out.println("Mapped: " + word + " as " + lexicon.get(word));
    }

    private static void mapPitLex(String[] s){

    }
}
