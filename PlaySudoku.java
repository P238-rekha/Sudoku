// Name: Palak Sharma
// Class: CS143
// HW Title and Core Topics: Sudoku Board Testing - Objects,
// Constructors, File Reading, and toString()
//
// This program creates a SudokuBoard object using a Sudoku
// data file and prints the board to the screen.

import java.io.FileNotFoundException;

public class PlaySudoku {

    // PRE: data1.sdk must exist in the same folder as this program.
    // POST: Creates a SudokuBoard object and prints the board.
    public static void main(String[] args) throws FileNotFoundException {

        SudokuBoard game = new SudokuBoard("data1.sdk");

        System.out.println(game);
    }
}

/* ----jGRASP exec: java PlaySudoku
 2 . . | 1 . 5 | . . 3 
 . 5 4 | . . . | 7 1 . 
 . 1 . | 2 . 3 | . 8 . 
 ------+-------+------
 6 . 2 | 8 . 7 | 3 . 4 
 . . . | . . . | . . . 
 1 . 5 | 3 . 9 | 8 . 6 
 ------+-------+------
 . 2 . | 7 . 1 | . 6 . 
 . 8 1 | . . . | 2 4 . 
 7 . . | 4 . 2 | . . 1 
 
 
  ----jGRASP: Operation complete.
  */
 