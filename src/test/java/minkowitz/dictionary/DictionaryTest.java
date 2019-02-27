package minkowitz.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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

    @Test
    public void palindromeTrueWithEvenChars() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.isPalindrome("hannah"));
    }

    @Test
    public void palindromeTrueWithOddChars() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.isPalindrome("kayak"));
    }

    @Test
    public void palindromeTrueWithSingleChar() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.isPalindrome("K"));
    }

    @Test
    public void palindromeTrueWithEmptyString() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();
        //when
        //then
        assertEquals(true, dictionary.isPalindrome(""));
    }
    @Test
    public void verifyListOfPalindromesContainsOnlyPalindromes() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();

        //when
        ArrayList<String> palindromes = dictionary.getPalindromes();
        //then
        for(String word : palindromes)
        {
            assertEquals(true, dictionary.isPalindrome(word));
        }
    }

    @Test
    public void verifyAfterRemovingPalindromesFromDictionaryThereAreNoneLeft() throws FileNotFoundException
    {
        Dictionary dictionary = new Dictionary();

        //when
        ArrayList<String> palindromes = dictionary.getPalindromes();
        for(String word : palindromes)
        {
            dictionary.removeWordFromDictionary(word);
        }
        //then
        for(String word : dictionary.getKeySet())
        {
           assertEquals(false, dictionary.isPalindrome(word));
        }
    }

    @Test
    public void sizeIsCorrect() throws FileNotFoundException
    {
        //given
        Dictionary dictionary = new Dictionary();

        //when
        //then
        assertEquals(167964, dictionary.getSize());
    }

}
