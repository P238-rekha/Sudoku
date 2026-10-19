// Name: Palak Sharma
// Class: CS143
// HW Title and Core Topics: Sudoku Board - 2D Arrays, File Reading,
// Constructors, Classes, and toString()
//
// This program creates a Sudoku board from a .sdk file.
// It stores the board in a 2D char array and provides a
// formatted String representation of the board.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard {

    // Stores the 9 x 9 Sudoku board.
    private char[][] board;

    // PRE: fileName must refer to a readable .sdk file containing
    // exactly 9 rows with 9 characters in each row.
    // POST: Creates a SudokuBoard object and stores the contents
    // of the file in the 2D board array.
    public SudokuBoard(String fileName) throws FileNotFoundException {

        board = new char[9][9];

        Scanner input = new Scanner(new File(fileName));

        for (int row = 0; row < 9; row++) {

            String line = input.nextLine();

            for (int col = 0; col < 9; col++) {
                board[row][col] = line.charAt(col);
            }
        }

        input.close();
    }

    // PRE: The SudokuBoard object has been created.
    // POST: Returns a formatted String containing all values
    // currently stored in the Sudoku board.
    public String toString() {

        String result = "";

        for (int row = 0; row < 9; row++) {

            if (row == 3 || row == 6) {
                result += "------+-------+------\n";
            }

            for (int col = 0; col < 9; col++) {

                if (col == 3 || col == 6) {
                    result += "| ";
                }

                result += board[row][col] + " ";
            }

            result += "\n";
        }

        return result;
    }
}