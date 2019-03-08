package minkowitz.bananagrams;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BananagramsTest {

    @Test
    public void isViableWordTrue()
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        boolean isViable = bananagrams.isViableWordGivenMyLetters("AA");
        //then
        assertTrue(isViable);
    }

    @Test
    public void isViableWordFalse()
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        boolean isViable = bananagrams.isViableWordGivenMyLetters("AB");
        //then
        assertFalse(isViable);
    }

    @Test
    public void isViableWordMixedCaseTrue()
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        boolean isViable = bananagrams.isViableWordGivenMyLetters("Aa");
        //then
        assertTrue(isViable);
    }

    //now that i've established that those words are viable
    //although, important to note that this is proof by exhaustion
    //so this is incomplete

    @Test
    public void verifyGetAllViableWordsAreAllViableWords() throws FileNotFoundException
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        ArrayList<String> wordList = bananagrams.getAllViableWordsGivenMyLetters();
        //then
        for(String word : wordList)
        {
            assertTrue(bananagrams.isViableWordGivenMyLetters(word));
        }
    }

    //how do i test if i missed words? should i use my dictionary and get the list
    //and remove like i did for palindrome? That sounds illegal
    @Test
    public void verifyAfterRemovingViableWordsFromDictionaryThereAreNoneLeft() throws FileNotFoundException
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        ArrayList<String> wordList = bananagrams.getAllViableWordsGivenMyLetters();
        for(String word : wordList)
        {
            bananagrams.dictionary.removeWordFromDictionary(word);
        }
        //then
        for(String word : bananagrams.dictionary.getKeySet())
        {
            assertFalse(bananagrams.isViableWordGivenMyLetters(word));
        }
    }
}