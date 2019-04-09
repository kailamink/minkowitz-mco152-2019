package minkowitz.bananagrams;

import minkowitz.dictionary.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Bananagrams {

    private ArrayList<String> myLetters = new ArrayList<>();
    private final int NR_OF_LETTERS = 14;
    private Dictionary dictionary;

    public Bananagrams(Dictionary dictionary)
    {
        this.dictionary = dictionary;
        initializeMyLetters();
    }

    public Bananagrams(Dictionary dictionary, String letters)
    {
        this.dictionary = dictionary;
        initializeMyLetters(letters);
    }

    public ArrayList<String> getAllViableWordsGivenMyLetters()
    {
        ArrayList<String> viableWords = new ArrayList<>();
        for(String word : dictionary.getKeySet())
        {
            if(word.length() <= NR_OF_LETTERS)
            {
                if(isViableWordGivenMyLetters(word)) { viableWords.add(word);}
            }
        }
        return viableWords;
    }

    public boolean isViableWordGivenMyLetters(String word)
    {
        String upperCased = word.toUpperCase();
        boolean isViableWord = true;
        ArrayList<String> poppedLetters = new ArrayList<>();
        for(int ix = 0; ix < upperCased.length(); ++ix)
        {
            if(myLetters.contains(Character.toString(upperCased.charAt(ix))))
            {
                myLetters.remove(Character.toString(upperCased.charAt(ix)));
                poppedLetters.add(Character.toString(upperCased.charAt(ix)));
            }
            else
            {
                isViableWord = false;
                break;
            }
        }
        for(String str : poppedLetters) { myLetters.add(str); }
        return isViableWord;
    }

    public ArrayList<String> getLetters()
    {
        return myLetters;
    }

    private void initializeMyLetters()
    {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        myLetters.clear();
        for(int ix = 0; ix < NR_OF_LETTERS; ++ix)
        {
            char chr = letters.charAt(rand.nextInt(letters.length()));
            myLetters.add(Character.toString(chr));
        }
    }

    public void initializeMyLetters(String letters)
    {
        myLetters.clear();
        String upperCased = letters.toUpperCase();
        for (int ix = 0; ix < upperCased.length(); ++ix)
        {
            char chr = upperCased.charAt(ix);
            myLetters.add(Character.toString(chr));
        }
    }
}
