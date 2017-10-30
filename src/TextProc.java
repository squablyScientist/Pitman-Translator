import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This file is responsible for processing all text mapping and loading that must be done. All information required for
 * such processing is read in at runtime. All methods within the class are meant to be used as a utilities, and thus the
 * processor should never be instantiated.
 *
 *@author Collin Tod
 */
public abstract class TextProc {

    //Path to CMULexicon dictionary
    private static final String LEXICONPATH = "src/strokeFiles/cmudict-0.7b.txt";

    //Path to list of vowel phonemes
    private static final String VOWELPATH = "src/strokeFiles/vowels";

    private static Set<Character> vowels = new HashSet<>();
    private static Map<String, List<Character>> lexicon;

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
     * @param s Any string
     * @return An array of arrays that hold the phones for all words within String s
     */
    public static Character[][] phones(String s) {
        String[] words = s.split(" ");

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
        lexicon = new HashMap<>();
        String line;

        //Try catch for IOException in file reader and buffered reader
        try(FileReader fr = new FileReader(LEXICONPATH);
            BufferedReader br = new BufferedReader(fr)) {
            //Map all the words in the CMUDictionary to their phonetic symbols


            //get past cmu copyright stuff, need to keep it in file as part of copyright
            for (int i = 0; i < 56; i++) {
                br.readLine();
            }

            //Map all of the words in the CMUdict to phoneme characters.
            while ((line = br.readLine()) != null) {
                mapLex(line);
            }
        }
        catch(IOException e){e.printStackTrace();}

        // read in all of the vowel phonemes and keep them in a set.
        try(FileReader fr = new FileReader(VOWELPATH)) {

            //add a bunch of vowels into the hash set to be compared against later
            int next;
             while ((next = fr.read()) != -1) {
                 vowels.add((char)next);
             }
        }
        catch(IOException e){e.printStackTrace(); }
     }


    /**
     * Maps a word to its correct phones based on one line of the CMU lexicon
     * @param s String of a word and its phones to be mapped to each other
     */
    private static void mapLex(String s){
        Scanner sc = new Scanner(s);
        List<Character> phones = new ArrayList<>();
        String word = sc.next();
        while(sc.hasNext()){
            phones.add(sc.next().charAt(0));
        }
        lexicon.put(word, phones);
    }

    /**
     * Checks whether or not a phoneme character is a vowel
     * @param c A phoneme character
     * @return if c is a vowel phonemes
     */
    static boolean isVowel(char c){
        return vowels.contains(c);
    }
}
