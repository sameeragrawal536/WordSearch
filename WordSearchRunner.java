import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class WordSearchRunner
{
  public static void main(String[] args) throws FileNotFoundException
	{
            // Instantiate Scanner object to read in from file
	    Scanner in = new Scanner(new File("Words.txt"));
	  
	   // Get dimensions of word search
	    String dim = in.nextLine();
	    String[] dims = dim.split(" ");
	    int[] dimm = new int[2];
	    int dimmm;
	    String[] letters;
	    for (int i = 0; i < 2; i++) {
	      dimmm = Integer.parseInt(dims[i]);
	      dimm[i] = dimmm;
	    }
	  
	    String space = in.nextLine();
		
           // Instantiate WordSearch object passing in number of rows & columns for 2D array
	   WordSearch100 words = new WordSearch100(dimm[1], dimm[0]);
	  
	  // Add all characters to WordSearch object
           char[] letter = new char[dimm[1]];
	   for (int j = 0; j < dimm[0]; j++){
	     String row = in.nextLine();
	     letters = row.split(" ");
	     for (int l = 0; l<letters.length; l++){
	     	letter[l] = letters[l].charAt(0);
		words.setSpot(letter[l], l, j);
	     }
	   }
	
	    // Read number of words to search for from file
	    String spaces = in.nextLine();
	    String wor = in.nextLine();
	    int wordcount = Integer.parseInt(wor);
			
	    // Loops through the words in the file, applying the "inGrid" method on each to check whether or not each word is in the word search
	    String wordtosearch;
	    boolean inword;
	    for (int z = 0; z < wordcount; z++){
	      wordtosearch = in.nextLine();
	      inword = words.inGrid(wordtosearch);
	      System.out.println(wordtosearch + " -> " + inword);
	    }
	    System.out.println("");
	  
	    // Uses "toString" method to print word search
	    System.out.println(words.toString());
  }
}
