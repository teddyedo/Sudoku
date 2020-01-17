/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.util.ArrayList;


/**
 *
 * @author Allari Edoardo
 *
 * @version 1.0.0 - 17/01/2020
 *
 */
public class solver {

    public boolean solve(int[][] sudoku) {

        //find the first free box
        ArrayList <Integer> emptyBox = isEmpty(sudoku);
        
        //if true, the sudoku is solved
        if(emptyBox.isEmpty()) {
            return true;
        }
        
        //else, get the position of the first empty box
        else{
            int row = emptyBox.get(0);
            int col = emptyBox.get(1);
        }
        
        //try to fill the empty box with every number from 1 to 9
        for (int i = 1; i < 10; i ++){
            
            
            //check if the choosen number is valid for that position
            if(isValid(sudoku, i, emptyBox)){
                sudoku[emptyBox.get(0)][emptyBox.get(1)] = i;
                
                /*I try again to solve the sudoku and I have to possibilities:
                  - if the function return true, it means that I reach the finish of the game;
                  - if the function return false, it means that my combination isn't valid, so 
                    I quit from the recursive function and reset my box with 0.   
                */
                
                if(solve(sudoku))
                    return true;
                
                //reset the current box
                sudoku[emptyBox.get(0)][emptyBox.get(1)] = 0;     
            }
        }        
        return false;
    }

    /**
     * Print into the console the scheme
     * @param sudoku a bidimensional int array 9x9
     */
    public void printSudoku(int[][] sudoku) {

        for (int i = 0; i < SudokuSolver.row; i++) {

            //print horizontal divisor
            if (i % 3 == 0 && i != 0) {
                System.out.println("- - - - - - - - - - -");

            }

            for (int j = 0; j < SudokuSolver.col; j++) {
                
                //print vertical divisor
                if(j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                
                //print the number at the end of the row   
                if(j == 8){
                    System.out.print(sudoku[i][j] + "\n");
                } 
                
                //print the number
                else{
                    System.out.print(sudoku[i][j] + " ");
                }    
            }
        }
    }

    
    /**
     * Find an empty box
     * @param sudoku our game table
     * @return the coords of the first empty box
     */
    public ArrayList isEmpty(int [][] sudoku){
        
        ArrayList<Integer> coords = new ArrayList<>();
        
        for (int i = 0; i < SudokuSolver.row; i ++){
            for (int j = 0; j < SudokuSolver.col; j ++){
                
                if(sudoku[i][j] == 0) {
                    coords.add(i);
                    coords.add(j);
                }           
            }
        }
        
        return coords;
    }
    
    
    /**
     * Check if the new number inserted is valid
     * @param sudoku our board table
     * @param num the num inserted 
     * @param coords the coords of the position (row, col) where insert num
     * @return true if the num is valid in the position given
     */
    public boolean isValid(int[][] sudoku, int num, ArrayList<Integer> coords){
        
        //check the row
        for (int i = 0; i < SudokuSolver.col; i ++){
            if(sudoku[coords.get(0)][i] == num && i != coords.get(1))
                return false;
        }
        
        //check the column
        for (int i = 0; i < SudokuSolver.row; i ++){
            if(sudoku[i][coords.get(1)] == num && i != coords.get(0))
                return false;
        }
        
        //check the little square
        
        int numX = coords.get(1) / 3;
        int numY = coords.get(0) / 3;
        
        for (int i = numY * 3; i < numY * 3 + 3; i ++){
            for (int j = numX * 3; j < numX * 3 + 3; j++){
                if (sudoku[i][j] == num && i != coords.get(0) && j != coords.get(1)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    
    
    
}
