package minkowitz.bananagrams;

import minkowitz.dictionary.Dictionary;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BananagramsTest {

    @Test
    public void isViableWordTrue() throws FileNotFoundException {
        //given
        Dictionary dictionary = new Dictionary();
        Bananagrams bananagrams = new Bananagrams(dictionary,"KAILA");
        //when
        boolean isViable = bananagrams.isViableWordGivenMyLetters("AA");
        //then
        assertTrue(isViable);
    }

    @Test
    public void isViableWordFalse() throws FileNotFoundException {
        //given
        Dictionary dictionary = new Dictionary();
        Bananagrams bananagrams = new Bananagrams(dictionary,"KAILA");
        //when
        boolean isViable = bananagrams.isViableWordGivenMyLetters("AB");
        //then
        assertFalse(isViable);
    }

    @Test
    public void isViableWordMixedCaseTrue() throws FileNotFoundException {
        //given
        Dictionary dictionary = new Dictionary();
        Bananagrams bananagrams = new Bananagrams(dictionary,"KAILA");
        //when
        boolean isViable = bananagrams.isViableWordGivenMyLetters("Aa");
        //then
        assertTrue(isViable);
    }

    //now that i've established that those words are viable
    //although, important to note that this is proof by exhaustion
    //so this is incomplete

    @Test
    public void verifyGetAllViableWordsAreAllViableWords()
    {
        //given
        Dictionary dictionary =  mock(Dictionary.class);
        Bananagrams bananagrams = new Bananagrams(dictionary,"KAILA");
        doReturn(new HashSet<String>(Arrays.asList("AA", "ION", "RAY", "CARTON", "JOY", "DICE"))).when(dictionary).getKeySet();
        //when
        ArrayList<String> wordList = bananagrams.getAllViableWordsGivenMyLetters();
        //then
        for(String word : wordList)
        {
            assertTrue(bananagrams.isViableWordGivenMyLetters(word));
        }
    }

    @Test
    public void verifyAfterRemovingViableWordsFromDictionaryThereAreNoneLeft()
    {
        //given
        Dictionary dictionary =  mock(Dictionary.class);
        Bananagrams bananagrams =
                new Bananagrams(dictionary,"DICTIONARY");
        HashSet<String> fakeDictionary =
                new HashSet<>(Arrays.asList("AA", "ION", "RAY", "CARTON", "JOY", "DICE"));
        doReturn(fakeDictionary).when(dictionary).getKeySet();
        //when
        ArrayList<String> wordList = bananagrams.getAllViableWordsGivenMyLetters();
        for(String word : wordList)
        {
            fakeDictionary.remove(word);
        }
        doReturn(fakeDictionary).when(dictionary).getKeySet();
        //then
        for(String word : dictionary.getKeySet())
        {
            assertFalse(bananagrams.isViableWordGivenMyLetters(word));
        }
    }
}