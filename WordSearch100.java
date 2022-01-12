import java.util.Arrays;
import java.util.ArrayList;

public class WordSearch100
{
	/** one 2D array instance variable named wordArray - You CANNOT add any additional instance variables */
	char[][] twoD_arr;
	
	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col*/
	public WordSearch100(int row, int col)
	{
		twoD_arr = new char[col][row];
	}
	
	/** method to set an element in the 2D array
		* @param s which is the value to store in the 2D array
		* @param row the row to use
		* @param col the column to use*/
	public void setSpot(char s, int row, int col)
	{
		twoD_arr[col][row] = s;
	}
	
	/** methods to check for the word in the 2D array
		* @param the word to search for
		* @return return true or false*/
	public boolean inGrid(String s)
	{
    boolean x = false;
    String backwards = "";
    for (int zz = 0; zz < s.length(); zz++){
      backwards += s.charAt(s.length()-(zz+1));
    }
    String[] rows = new String[twoD_arr.length];
    String[] columns = new String[twoD_arr[0].length];
    ArrayList<String> diagonals = new ArrayList<String>();

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
	
	/** toString method
		* @return String containing all elements in the 2D array*/
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