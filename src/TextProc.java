import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextProc {

    //Path to CMULexicon dictionary
    private static final String LEXICONPATH = "src/strokeFiles/cmudict-0.7b.txt";
    private static final String PITMANLEXPATH = "src/strokeFiles/PitmanLex";
    private static Map<String, List<Character>> lexicon;
    private static Map<String, Character> pitmanLex;

    /**
     * Splits a bunch of words into an array of a bunch of words
     *
     * @param s The string of multiple words which will be split into an array of each word
     * @return An array of strings, each one word of the string s
     */
    private static String[] wordsSplit(String s) {
        return s.split("\\s");
    }

    /**
     * Grabs the phones of a word from lexicon hashmap, which is populated by the words withing the CMULexicon
     * @param s A word that should be in the CMULexicon
     * @return an array of strings that hold the phones for the word in String s
     * @throws IllegalArgumentException If the word given is not in the CXMULexicon, then an illegeal argument exception is thrown
     */
    private static Character[] getWordSymbols(String s) throws IllegalArgumentException{
        List<Character> phoneList;
        if((phoneList = lexicon.get(s.toUpperCase())) != null){
            return phoneList.toArray(new Character[phoneList.size()]);
        }
        throw new IllegalArgumentException("Not in lexicon");

    }
    /**
     * Entire string to phone arrays
     *
     * @param s Any string
     * @return An array of arrays that hold the phones for all words within String s
     */
    public static Character[][] phones(String s) {
        String[] words = wordsSplit(s);

        //2d array of characters with one dimension defined as the amount of words in String s
        Character[][] phones = new Character[words.length][];

        for (int i = 0; i < phones.length; i++) {
            try {
                phones[i] = getWordSymbols(words[i]);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();

            }
        }
        return phones;
    }

    /**
     * Runtime loading of lexicon mappings of phonemes, symbols, and (NOT IMPLEMENTED) pitman strokes
     */
     static void load(){
        lexicon = new HashMap<>(133910);
        pitmanLex = new HashMap<>(84);
        BufferedReader br;
        FileReader fr;
        String line;

        try{

            //Map all phonetic symbols to the phonemes in the CMUDictionary
            fr = new FileReader(PITMANLEXPATH);
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                mapPitLex(line);
            }

            //Map all the words in the CMUDictionary to their phonetic symbols
            fr = new FileReader(LEXICONPATH);
            br = new BufferedReader(fr);

            //get past cmu copyright stuff
            for(int i = 0; i < 56; i++){
                br.readLine();
            }

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
        List<Character> phones = new ArrayList<>();
        String word = sc.next();
        while(sc.hasNext()){
            phones.add(pitmanLex.get(sc.next()));
        }
        lexicon.put(word, phones);
        System.out.println("Mapped: " + word + " as " + lexicon.get(word));
    }

    /**
     * Maps a phoneme to it's phonetic character based on a many to one mapping file
     * @param s String made up of a phoneme and a phonetic character separated by a space
     */
    private static void mapPitLex(String s){
        Scanner sc = new Scanner(s);
        String phone = sc.next();
        pitmanLex.put(phone, sc.next().charAt(0));
        System.out.println("Mapped " + phone + " as " + pitmanLex.get(phone));
    }
}
