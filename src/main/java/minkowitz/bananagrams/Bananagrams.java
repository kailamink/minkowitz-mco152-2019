package minkowitz.bananagrams;

import minkowitz.dictionary.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Bananagrams {

    public ArrayList<String> myLetters = new ArrayList<>();
    public final int NR_OF_LETTERS = 14;
    public Dictionary dictionary;

    public Bananagrams()
    {
        initializeMyLetters();
    }

    public Bananagrams(String letters)
    {
        initializeMyLetters(letters);
    }

    public ArrayList<String> getAllViableWordsGivenMyLetters() throws FileNotFoundException
    {
        ArrayList<String> viableWords = new ArrayList<>();
        dictionary = new Dictionary();
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
        letters.toUpperCase();
        for (int ix = 0; ix < letters.length(); ++ix)
        {
            char chr = letters.charAt(ix);
            myLetters.add(Character.toString(chr));
        }
    }
}
