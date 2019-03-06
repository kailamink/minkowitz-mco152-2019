package minkowitz.bananagrams;

import minkowitz.dictionary.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Bananagrams {

    public ArrayList<String> myLetters = new ArrayList<>();
    public final int NR_OF_LETTERS = 14;
    Dictionary dictionary;

    public Bananagrams ()
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
                for(int ix = 0; ix < NR_OF_LETTERS; ++ix)
                {

                }
            }
        }
        return viableWords;
    }
    private void initializeMyLetters()
    {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int ix = 0; ix < NR_OF_LETTERS; ++ix)
        {
            char chr = letters.charAt(rand.nextInt(letters.length()));
            myLetters.add(Character.toString(chr));
        }
    }
}
