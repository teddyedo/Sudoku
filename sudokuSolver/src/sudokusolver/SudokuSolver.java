/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.util.Scanner;

/**
 *
 * @author Allari Edoardo
 * 
 * @version 1.0.0 - 17/01/2020
 * 
 */

public class SudokuSolver {

    public static int row = 9;
    public static int col = 9;
    public static int[][] sudoku = new int[row][col];

    public static void main(String[] args) {
        
        //intialize an empty table
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                
                sudoku[i][j] = 0;
                
            }
        }
        
        //develop an input method to allow user to insert his sudoku
        
        System.out.println("Quanti numeri ci sono già inseriti nel sudoku che vuoi risolvere? ");
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        
        //sudoku manually filled for tests
        
        sudoku[0][1] = 3;
        sudoku[0][4] = 7;
        sudoku[0][5] = 6;
        sudoku[0][7] = 5;
        sudoku[1][1] = 6;
        sudoku[1][5] = 3;
        sudoku[1][6] = 2;
        sudoku[1][8] = 4;
        sudoku[2][0] = 5;
        sudoku[2][3] = 4;
        sudoku[2][6] = 6;
        sudoku[3][0] = 2;
        sudoku[3][4] = 6;
        sudoku[3][6] = 4;
        sudoku[4][1] = 7;
        sudoku[4][2] = 3;
        sudoku[4][3] = 5;
        sudoku[4][8] = 9;
        sudoku[5][2] = 6;
        sudoku[5][5] = 4;
        sudoku[6][0] = 3;
        sudoku[6][2] = 8;
        sudoku[6][5] = 1;
        sudoku[6][7] = 7;
        sudoku[7][0] = 6;
        sudoku[7][2] = 1;
        sudoku[7][3] = 7;
        sudoku[8][3] = 3;
        sudoku[8][4] = 4;
        sudoku[8][6] = 9;
        
        
        solver s = new solver();
        
        s.solve(sudoku);
        
        s.printSudoku(sudoku);
        
                
    }
    
}
