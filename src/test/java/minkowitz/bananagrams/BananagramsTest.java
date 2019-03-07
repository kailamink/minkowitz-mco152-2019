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
        boolean isViable = bananagrams.isViableWord("AA");
        //then
        assertTrue(isViable);
    }

    @Test
    public void isViableWordFalse()
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        boolean isViable = bananagrams.isViableWord("AB");
        //then
        assertFalse(isViable);
    }

    @Test
    public void isViableWordMixedCaseTrue()
    {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        boolean isViable = bananagrams.isViableWord("Aa");
        //then
        assertTrue(isViable);
    }

    //now that i've established that it's getting viable words
    @Test
    public void getAllViableWords() throws FileNotFoundException {
        //given
        Bananagrams bananagrams = new Bananagrams("KAILA");
        //when
        ArrayList<String> words = bananagrams.getAllViableWords();
        //then
    }
}