import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class WordSearchRunner
{
  public static void main(String[] args) throws FileNotFoundException
	{
		// instantiate Scanner object to read in from file
    Scanner in = new Scanner(new File("Words.txt"));
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
		// read in rows
    
		
		// read in columns
		
		// instantiate WordSearch object passing in number of rows & columns for 2D array
		WordSearch100 words = new WordSearch100(dimm[1], dimm[0]);
    char[] letter = new char[dimm[1]];
    for (int j = 0; j < dimm[0]; j++){
      String row = in.nextLine();
      letters = row.split(" ");
      for (int l = 0; l<letters.length; l++){
        letter[l] = letters[l].charAt(0);
        words.setSpot(letter[l], l, j);
      }
    }
		// loop through the rows in the file

			// loop through the columns in the file
			
				// read in value from file using local variable
				
				// pass row, column, and value into the 2D array
		
    String spaces = in.nextLine();
    String wor = in.nextLine();
    int wordcount = Integer.parseInt(wor);
		// read number of words to search for from file
    
		String wordtosearch;
    boolean inword;
		// loops through the words
    for (int z = 0; z < wordcount; z++){
      wordtosearch = in.nextLine();
      inword = words.inGrid(wordtosearch);
      System.out.println(wordtosearch + " -> " + inword);
    }
    System.out.println("");
    System.out.println(words.toString());
		
			// read in word from file
			
			// method call to search for the word in the 2D array
			
			// print out word to search for and true/false
  }
}