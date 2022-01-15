import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class WordSearchRunner
{
  public static void main(String[] args) throws FileNotFoundException
	{
            
	    Scanner in = new Scanner(new File("Words.txt"));                  // Instantiate Scanner object to read in from file
	    
	    /////////////////////////////////////////////////////////////////
	    //////////////// Get dimensions of word search //////////////////
	    /////////////////////////////////////////////////////////////////
	    String dim = in.nextLine();                                       // Reading in line of file which has word search dimensions
	    String[] dims = dim.split(" ");                                                               
	    int[] dimm = new int[2];
	    int dimmm;
	    String[] letters;
	    for (int i = 0; i < 2; i++) {
	      dimmm = Integer.parseInt(dims[i]);
	      dimm[i] = dimmm;                                                // Array which holds dimensions of word search          
	    }
	  
	    String space = in.nextLine();  
	    WordSearch100 words = new WordSearch100(dimm[1], dimm[0]);        // Instantiate WordSearch object passing in number of rows & columns for 2D array
	  
	    /////////////////////////////////////////////////////////////////
	    /////////// Add all characters to WordSearch object /////////////
	    /////////////////////////////////////////////////////////////////
            char[] letter = new char[dimm[1]];                                // Create array of characters with length of array row
	    for (int j = 0; j < dimm[0]; j++){
	      String row = in.nextLine();
	      letters = row.split(" ");                                       // Create an array which holds each character of one array in the word search
	      for (int l = 0; l<letters.length; l++){                         // Loop through each character in a row
	     	letter[l] = letters[l].charAt(0);  
		words.setSpot(letter[l], l, j);                               // Add character at this position to the word search
	      }
	    }

	    /////////////////////////////////////////////////////////////////
	    ///////// Read number of words to search for from file //////////
	    /////////////////////////////////////////////////////////////////
	    String spaces = in.nextLine();
	    String wor = in.nextLine();
	    int wordcount = Integer.parseInt(wor);
			
	    /////////////////////////////////////////////////////////////////
	    /////// Checks if each word in the file in the word search //////
	    /////////////////////////////////////////////////////////////////
	    String wordtosearch;
	    boolean inword;
	    for (int z = 0; z < wordcount; z++){
	      wordtosearch = in.nextLine();                                   // Read next word to search for in file 
	      inword = words.inGrid(wordtosearch);                            // Apply inGrid to this word
	      System.out.println(wordtosearch + " -> " + inword);             // Print whether or not this word is in word search
	    }
	    System.out.println("");
	  

	    System.out.println(words.toString());                             // Apply toString method on word search and print
  }
}
