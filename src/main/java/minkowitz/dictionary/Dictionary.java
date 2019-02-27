package minkowitz.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

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
        return dictionary.get(word.toUpperCase());
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
        return word.equalsIgnoreCase(reverseString(word));
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
        StringBuilder reverse = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; --i)
        {
            reverse.append(word.charAt(i));
        }
        return reverse.toString();
    }

    public boolean removeWordFromDictionary(String word)
    {
        if(dictionary.containsKey(word.toUpperCase()))
        {
            dictionary.remove(word);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Set<String> getKeySet()
    {
        return dictionary.keySet();
    }
}
