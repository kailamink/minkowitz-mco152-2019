package minkowitz.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {

    @Test
    public void containsTrue() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.contains("AA"));
    }

    @Test
    public void containsFalse() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(false, dictionary.contains("booga"));
    }

    @Test
    public void containsTrueMixedCase() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.contains("aA"));
    }

    @Test
    public void palindromeTrue() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.isPalindrome("AA"));
    }

    @Test
    public void palindromeFalse() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(false, dictionary.isPalindrome("kaila"));
    }

    @Test
    public void palindromeTrueMixedCase() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.isPalindrome("Hannah"));
    }

//    @Test
//    public void getPalindromes() throws FileNotFoundException

}
