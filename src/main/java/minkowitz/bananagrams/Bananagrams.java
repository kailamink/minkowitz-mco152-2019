package minkowitz.bananagrams;

import minkowitz.dictionary.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Bananagrams {

    public ArrayList<String> myLetters = new ArrayList<>();
    public final int NR_OF_LETTERS = 14;
    Dictionary dictionary;

    public Bananagrams()
    {
        initializeMyLetters();
    }

    public ArrayList<String> getAllViableWords() throws FileNotFoundException {
        ArrayList<String> viableWords = new ArrayList<>();
        dictionary = new Dictionary();
        for(String word : dictionary.getKeySet())
        {
            if(word.length() <= NR_OF_LETTERS)
            {
                ArrayList<String> poppedLetters = new ArrayList<>();
                boolean isViableWord = true;
                for(int ix = 0; ix < word.length(); ++ix)
                {
                    if(myLetters.contains(Character.toString(word.charAt(ix))))
                    {
                        myLetters.remove(Character.toString(word.charAt(ix)));
                        poppedLetters.add(Character.toString(word.charAt(ix)));
                    }
                    else
                    {
                        isViableWord = false;
                        break;
                    }
                }
                for(String str : poppedLetters) { myLetters.add(str); }
                if(isViableWord) { viableWords.add(word);}
            }
        }
        return viableWords;
    }

    public ArrayList<String> getLetters()
    {
        return myLetters;
    }

    private void initializeMyLetters()
    {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        for(int ix = 0; ix < NR_OF_LETTERS; ++ix)
        {
            char chr = letters.charAt(rand.nextInt(letters.length()));
            myLetters.add(Character.toString(chr));
        }
    }
}
