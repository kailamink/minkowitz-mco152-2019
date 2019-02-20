package minkowitz.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String, String> dictionary = new HashMap<>();

    public Dictionary() throws FileNotFoundException {
        loadDictionary();
    }

    private void loadDictionary() throws FileNotFoundException {
        try (Scanner file = new Scanner(new File("dictionary.txt")))
        {
            while(file.hasNext())
            {
                String key = file.next();
                if(file.hasNextLine()) {
                    String value = file.nextLine();
                    dictionary.put(key.toUpperCase(),value);
                }
            }
        }
    }

    public String lookupWord(String word)
    {
        if(contains(word))
        {
            return dictionary.get(word.toUpperCase());
        }
        else
        {
            return "That word was not found";
        }
    }

    public int getSize()
    {
        return dictionary.size();
    }

    public boolean contains(String word)
    {
        return dictionary.containsKey(word.toUpperCase());
    }

    public boolean isPalindrome(String word)
    {
        if(word.equalsIgnoreCase(reverseString(word)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ArrayList<String> getPalindromes()
    {
        ArrayList<String> palindromes = new ArrayList<>();
        for(String key : dictionary.keySet())
        {
            if(isPalindrome(key))
            {
                palindromes.add(key);
            }
        }
        return palindromes;
    }

    private String reverseString(String word)
    {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; --i)
        {
            reverse = reverse + word.charAt(i);
        }
        return reverse;
    }
}
