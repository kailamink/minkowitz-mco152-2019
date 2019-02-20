package minkowitz.dictionary;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
//        ArrayList<String> myList = new ArrayList<>();
//        try (Scanner file = new Scanner(new File("dictionary.txt")))
//        {
//            while(file.hasNext())
//            {
//                myList.add(file.next());
//                if(file.hasNextLine()) {
//                    file.nextLine();
//                }
//            }
//           // printArrayList(myList);
//            System.out.println("size is: " + myList.size());
//            System.out.println(isValidWord(myList, "AA") ? "AA is valid" : "AA is not valid");
//            System.out.println(isValidWord(myList, "booga") ? "booga is valid" : "booga is not valid");
//        }
//        catch(Exception exc)
//        {
//            System.out.println(exc.getMessage());
//        }
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.lookupWord("AA"));
        System.out.println("size: " + dictionary.getSize());
        System.out.println(dictionary.contains("AA")? "AA is valid" : "AA is not valid");
        System.out.println(dictionary.contains("booga")? "booga is valid" : "booga is not valid");
    }

//    public static void printArrayList(ArrayList<String> myList)
//    {
//        for(String str : myList)
//        {
//            System.out.println(str);
//        }
//    }
//
//    public static boolean isValidWord(ArrayList<String> myList, String word)
//    {
//        if(myList.contains(word))
//        {
//            return true;
//        }
//        return false;
//    }
}
