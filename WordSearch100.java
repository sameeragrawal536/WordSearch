import java.util.Arrays;
import java.util.ArrayList;

public class WordSearch100
{
	/* Create the word search 2D array given the length of a row and a column */
	char[][] twoD_arr;

	public WordSearch100(int row, int col)
	{
		twoD_arr = new char[col][row];
	}
	
	/* Set a specific character at a certain point in the array */
	public void setSpot(char s, int row, int col)
	{
		twoD_arr[col][row] = s;
	}
	
	/* Check if a certain string is present in the word search. To do this, we are creating an array of strings for the rows, another array for the columns, 
	and another for diagonals. We loop through each row, column, or diagonal in the array, adding this row to our list. Eventually, we will have an array 
	with each row of the word puzzle, another with each column, and a third with each diagonal. Then, we can just go through each of the elements in each 
	array, and find if any contain the string we are looking for. It is a "brute force" method, but is still quick for reasonably sized word puzzles. */
	public boolean inGrid(String s)
	{
	    boolean x = false;
	    String backwards = "";
	    for (int zz = 0; zz < s.length(); zz++){
	      backwards += s.charAt(s.length()-(zz+1));
	    }
		
	    /* Defining arrays which will store rows, columns, and diagonals */
	    String[] rows = new String[twoD_arr.length];
	    String[] columns = new String[twoD_arr[0].length];
	    ArrayList<String> diagonals = new ArrayList<String>();
	    
	    /* Looping through each row/column in the word search, adding it to our array */
	    for (int i = 0; i < twoD_arr.length; i++){
	      for (int j = 0; j < twoD_arr[0].length; j++){
		rows[i] += twoD_arr[i][j];
	      }
	    }

	    for (int k = 0; k < twoD_arr[0].length; k++) {
	      for (int l = 0; l < twoD_arr.length; l++) {
		columns[k] += twoD_arr[l][k];
	      }
	    }
		
	    /* Looping through diagonals */
	    int k;
	    int v;
	    String diagonal = "";
	    for (int m = 1; m < twoD_arr[0].length-1; m++){
	      k = m;
	      v = 0;
	      diagonal += twoD_arr[0][m];
	      while (k > 0 && (v < twoD_arr.length-1)) {
		k--;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	      k = m;
	      v = 0;
	      while ((k < twoD_arr[0].length-1) && (v < twoD_arr.length-1)) {
		k++;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	    }

	    for (int m = 1; m < twoD_arr[0].length-1; m++){
	      k = m;
	      v = twoD_arr.length-1;
	      diagonal += twoD_arr[twoD_arr.length-1][m];
	      while (k > 0 && (v > 0)) {
		k--;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	      k = m;
	      v = twoD_arr.length-1;
	      while ((k < twoD_arr[0].length-1) && (v > 0)) {
		k++;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	    }

	    for (int m = 1; m < twoD_arr.length; m++){
	      k = 0;
	      v = m;
	      diagonal += twoD_arr[v][0];
	      while (k < twoD_arr[0].length-1 && (v > 0)) {
		k++;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	      k = 0;
	      v = m;
	      while ((k < twoD_arr[0].length-1) && (v < twoD_arr.length-1)) {
		k++;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	    }

	    for (int m = 1; m < twoD_arr.length; m++){
	      k = twoD_arr[0].length-1;
	      v = m;
	      diagonal += twoD_arr[v][0];
	      while (k > 0 && (v > 0)) {
		k--;
		v--;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	      k = twoD_arr[0].length-1;
	      v = m;
	      while ((k > 0) && (v < twoD_arr.length-1)) {
		k--;
		v++;
		diagonal += twoD_arr[v][k];
	      }
	      diagonals.add(diagonal);
	      diagonal = "";
	    }
		
	    /* Checking if the word exists in any of the arrays we created */
	    for (int m = 0; m < rows.length; m++){
	      if (rows[m].contains(s)) {
		x = true;
	      }
	      else if (rows[m].contains(backwards)){
		x = true;
	      }
	    }
	    if (x == false) {
	      for (int m = 0; m < columns.length; m++){
		if (columns[m].contains(s)) {
		  x = true;
		}
		else if (columns[m].contains(backwards)){
		  x = true;
		}
	      }
	    }

	    if (x == false) {
	      for (int m = 0; m < diagonals.size(); m++){
		if (diagonals.get(m).contains(s)) {
		  x = true;
		}
		else if (diagonals.get(m).contains(backwards)){
		  x = true;
		}
	      }
	    }
	    return x;
	  }

	/* ToString method, returns a string version of the array. */
	public String toString()
	{
	    String output = "[[ ";
	    for (int i = 0; i < twoD_arr.length; i++){
	      for (int j = 0; j < twoD_arr[i].length; j++) {
		output += twoD_arr[i][j];
		output += " ";
	      }
	      if (i < twoD_arr.length-1){
		output += "]\n [ ";
	      }
	      else {
		output += "]]";
	      }
	    }
	    return output;
	}
}
