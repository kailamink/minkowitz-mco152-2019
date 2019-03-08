package minkowitz.bananagrams;

import java.io.FileNotFoundException;

public class Main
{
    public static void main(String [] args) throws FileNotFoundException {
        Bananagrams bananagrams = new Bananagrams();
        bananagrams.getLetters().stream().forEach(System.out::print);
        bananagrams.getAllViableWordsGivenMyLetters().stream().forEach(System.out::println);
    }
}
