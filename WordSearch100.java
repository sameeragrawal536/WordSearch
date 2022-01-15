import java.util.Arrays;
import java.util.ArrayList;

public class WordSearch100
{
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	/*/*/*/*/*/*/* Create word search 2D array if given length of a row & a column */*/*/*
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/
	char[][] twoD_arr;

	public WordSearch100(int row, int col)
	{
		twoD_arr = new char[col][row];
	}
	
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	/*/*/*/*/*/*/*/*/*/*/*/*/* Set character at a specific position */*/*/*/**/*/*/*/*/*/* 
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/
	public void setSpot(char s, int row, int col)
	{
		twoD_arr[col][row] = s;
	}
	
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	/*/*/*/*/*/*/*/*/**/*/* Check if a certain string is in word search */*/*/*/**/*/*/*/*
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/
	public boolean inGrid(String s)
	{
		
	    /* Loop through all columns, rows, and diagonals, creating string arrays representing them */
	    boolean x = false;                                                    /* Variable representing whether or not word is found in the word search */
	    String backwards = ""; 
	    for (int zz = 0; zz < s.length(); zz++){
	      backwards += s.charAt(s.length()-(zz+1));                           /* Creating a backwards version of the string so program can find backwards words too */
	    }
		
	    String[] rows = new String[twoD_arr.length];                          /* Array that will store strings representing each row of the array */
	    String[] columns = new String[twoD_arr[0].length];                    /* Array that will store string representing each column of the array */
	    ArrayList<String> diagonals = new ArrayList<String>();
	    
	    for (int i = 0; i < twoD_arr.length; i++){
	      for (int j = 0; j < twoD_arr[0].length; j++){
		rows[i] += twoD_arr[i][j];                                        /* Looping through each row in the word search, adding it to our row array */
	      }
	    }

	    for (int k = 0; k < twoD_arr[0].length; k++) {
	      for (int l = 0; l < twoD_arr.length; l++) {
		columns[k] += twoD_arr[l][k];                                     /* Looping through each column in the word search, adding it to our column array */
	      }
	    }

	    int k;
	    int v;
	    String diagonal = "";
	    for (int m = 1; m < twoD_arr[0].length-1; m++){                       /* Start at value to the right of the top left corner of the array, and then slowly go across the top row */
	      k = m;
	      v = 0;
	      diagonal += twoD_arr[0][m];
	      while (k > 0 && (v < twoD_arr.length-1)) {                          /* For this position on the top row, create a string representing the diagonal that extends down and left */
		k--;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	      k = m;
	      v = 0;
	      while ((k < twoD_arr[0].length-1) && (v < twoD_arr.length-1)) {     /* Now, at this same position on the top row, create a string representing the diagonal that extends down and right */
		k++; 
		v++;
		diagonal += twoD_arr[v][k];                                      
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */                  
	      diagonal = "";
	    }

	    for (int m = 1; m < twoD_arr[0].length-1; m++){                       /* Start at value to the right of the bottom left corner of the array, and then slowly go across the bottom row */
	      k = m;
	      v = twoD_arr.length-1;
	      diagonal += twoD_arr[twoD_arr.length-1][m];
	      while (k > 0 && (v > 0)) {                                          /* For this position on the bottom row, create a string representing the diagonal that extends up and left */
		k--;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	      k = m;
	      v = twoD_arr.length-1;
	      while ((k < twoD_arr[0].length-1) && (v > 0)) {                     /* Now, at this same position on the bottom row, create a string representing the diagonal that extends up and right */
		k++;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	    }

	    for (int m = 1; m < twoD_arr.length; m++){                            /* Start the value right below the top left corner of the array, and then slowly go down this left column */
	      k = 0;
	      v = m;
	      diagonal += twoD_arr[v][0];
	      while (k < twoD_arr[0].length-1 && (v > 0)) {                       /* For this position on the left column, create a string representing the diagonal that extends up and right */
		k++;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	      k = 0;
	      v = m;
	      while ((k < twoD_arr[0].length-1) && (v < twoD_arr.length-1)) {     /* Now, at this position on the left column, create a string representing the diagonal that extends down and right */
		k++;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	    }

	    for (int m = 1; m < twoD_arr.length; m++){                            /* Start at the position right below the top right corner of the array, and then slowly go down this right column */                      
	      k = twoD_arr[0].length-1;
	      v = m;
	      diagonal += twoD_arr[v][0];
	      while (k > 0 && (v > 0)) {                                          /* For this position on the right column, create a string representing the diagonal that extends up and left */
		k--;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	      k = twoD_arr[0].length-1;
	      v = m;
	      while ((k > 0) && (v < twoD_arr.length-1)) {                        /* Now, at this position on the right column, create a string representing the diagonal that extends down and left */
		k--;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);                                            /* Add this string to the array */
	      diagonal = "";
	    }
		
	    /* Checking if the word exists in any of the arrays we created */
	    for (int m = 0; m < rows.length; m++){ 
	      if (rows[m].contains(s)) {                                          /* Looping through the rows array, check if the word is in any of the rows */
		x = true;                          
	      }
	      else if (rows[m].contains(backwards)){                              /* Looping through the rows array, check if the backwards word is in any of the rows */
		x = true;
	      }
	    }
	    if (x == false) {                          
	      for (int m = 0; m < columns.length; m++){                           /* If the word isn't in a row, start looking through columns */
		if (columns[m].contains(s)) {
		  x = true;
		}
		else if (columns[m].contains(backwards)){                         /* If word isn't found here, check backwards version of the word */
		  x = true;
		}
	      }
	    }

	    if (x == false) {
	      for (int m = 0; m < diagonals.size(); m++){                         /* If the word isn't in a column either, start looking through diagonals */
		if (diagonals.get(m).contains(s)) {
		  x = true;
		}
		else if (diagonals.get(m).contains(backwards)){                   /* If the word isn't found in diagonals, check the backwards version */
		  x = true;
		}
	      }
	    }
	    return x;
	  }

	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*
	/*/*/*/*/*/**/*/* ToString method, returns a string version of the array. */*/*/*/**/*
	/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/
	public String toString()
	{
	    String output = "[[ ";                                   /* Stores the string version of array */
	    for (int i = 0; i < twoD_arr.length; i++){
	      for (int j = 0; j < twoD_arr[i].length; j++) {         /* Loop through each element of array */
		output += twoD_arr[i][j];
		output += " ";                                       /* Add all values of this row to the output string */
	      }
	      if (i < twoD_arr.length-1){
		output += "]\n [ ";                                  /* If the end of the row is reached, create a new row */
	      }
	      else {
		output += "]]";                                      /* If the end of the entire array is reached, close the array with double brackets */
	      }
	    }
	    return output;                                           /* Return output string */
	}
}
