# WordSearch
A simple Java program which takes reads in a txt file with a 2D grid of characters (a word puzzle), followed by a list of words. The program will output whether each word is present in the word puzzle. The program can find words that are backwards and words that are diagonal as well.

To create your own word puzzle to input into the program, make sure the txt file follows the following layout:
 - First line will have two integers: m, the number of lines in the grid, and n, the number of characters in each line. The integers m and n will be separated by one space.
 - There will be a single blank line.
 - There will be m lines, where each line will have n characters, all in uppercase, separated by a space.
 - There will be a single blank line.
 - There will be a single integer k, denoting the number of words that follow.
 - There will be k lines. Each line will contain a single word in all uppercase.
