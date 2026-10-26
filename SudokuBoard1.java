// Name: Palak Sharma
// Class: CS143
// HW Title and Core Topics: Sudoku #2 - Sets, Maps, Efficiency,
// 2D Arrays, Helper Methods, isValid(), and isSolved()
//
// This program reads a Sudoku board from a .sdk file and stores it
// in a 2D char array. It checks whether the board contains valid data,
// whether rows, columns, and 3x3 mini-squares contain duplicate values,
// and whether the Sudoku board is completely solved.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class SudokuBoard1 {

    // Stores the 9 x 9 Sudoku board.
    private char[][] board;


    // PRE: fileName must refer to a readable .sdk file containing
    // exactly 9 rows with 9 characters in each row.
    // POST: Creates a SudokuBoard1 object and stores the contents
    // of the file in the 2D board array.
    public SudokuBoard1(String fileName) throws FileNotFoundException {

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


    // PRE: The SudokuBoard1 object has been created.
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


    // PRE: The SudokuBoard1 object has been created.
    // POST: Returns true if all data, rows, columns, and mini-squares
    // follow the Sudoku rules; otherwise returns false.
    public boolean isValid() {

        return hasValidData()
                && rowsValid()
                && columnsValid()
                && miniSquaresValid();
    }


    // PRE: The SudokuBoard1 object has been created.
    // POST: Returns true if every cell contains a valid number,
    // each number 1-9 appears exactly 9 times, and the board is valid.
    // Returns false otherwise.
    public boolean isSolved() {

        if (!isValid()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                // A solved board cannot contain empty cells.
                if (value == '.') {
                    return false;
                }

                if (counts.containsKey(value)) {
                    counts.put(value, counts.get(value) + 1);
                } else {
                    counts.put(value, 1);
                }
            }
        }

        for (char value = '1'; value <= '9'; value++) {
            if (!counts.containsKey(value) || counts.get(value) != 9) {
                return false;
            }
        }

        return true;
    }


    // PRE: The board has been initialized.
    // POST: Returns true if every board cell contains either
    // a digit 1-9 or a period representing an empty cell.
    private boolean hasValidData() {

        Set<Character> valid = new HashSet<>();

        valid.add('.');
        valid.add('1');
        valid.add('2');
        valid.add('3');
        valid.add('4');
        valid.add('5');
        valid.add('6');
        valid.add('7');
        valid.add('8');
        valid.add('9');

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (!valid.contains(board[row][col])) {
                    return false;
                }
            }
        }

        return true;
    }


    // PRE: The board has been initialized.
    // POST: Returns true if no row contains duplicate digits 1-9.
    // Periods are ignored because multiple empty cells are allowed.
    private boolean rowsValid() {

        for (int row = 0; row < 9; row++) {

            Set<Character> seen = new HashSet<>();

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value != '.') {

                    if (seen.contains(value)) {
                        return false;
                    }

                    seen.add(value);
                }
            }
        }

        return true;
    }


    // PRE: The board has been initialized.
    // POST: Returns true if no column contains duplicate digits 1-9.
    // Periods are ignored because multiple empty cells are allowed.
    private boolean columnsValid() {

        for (int col = 0; col < 9; col++) {

            Set<Character> seen = new HashSet<>();

            for (int row = 0; row < 9; row++) {

                char value = board[row][col];

                if (value != '.') {

                    if (seen.contains(value)) {
                        return false;
                    }

                    seen.add(value);
                }
            }
        }

        return true;
    }


    // PRE: spot must be between 1 and 9.
    // POST: Returns the requested 3 x 3 mini-square
    // from the Sudoku board.
    private char[][] miniSquare(int spot) {

        char[][] mini = new char[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                mini[r][c] =
                        board[((spot - 1) / 3 * 3) + r]
                             [((spot - 1) % 3 * 3) + c];
            }
        }

        return mini;
    }


    // PRE: The board has been initialized.
    // POST: Returns true if all nine 3 x 3 mini-squares contain
    // no duplicate digits 1-9. Empty cells are ignored.
    private boolean miniSquaresValid() {

        for (int spot = 1; spot <= 9; spot++) {

            char[][] mini = miniSquare(spot);
            Set<Character> seen = new HashSet<>();

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {

                    char value = mini[row][col];

                    if (value != '.') {

                        if (seen.contains(value)) {
                            return false;
                        }

                        seen.add(value);
                    }
                }
            }
        }

        return true;
    }
}