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
        
        
        solver s = new solver();


        //intialize an empty table
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                
                sudoku[i][j] = 0;
                
            }
        }
        
        //develop an input method to allow user to insert his sudoku
        
        System.out.println("Quanti numeri ci sono già inseriti nel sudoku che "
                + "vuoi risolvere? ");
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        System.out.println("Inserisci i numeri presenti nello schema che vuoi "
                + "risolvere secondo il seguente schema: RCN, dove: \n"
                + "R -> Riga \n"
                + "C -> Colonna \n"
                + "N -> Numero \n"
                + "Ad esempio 846 significa alla riga 8, colonna 4, metti il 6"
                + "\n"
                + "N.B. Se ci si accorge di aver sbagliato l'inserimento di un"
                + "numero, inserire il codice 999, premere invio e proseguire"
                + "con l'inserimento dei numeri");
        
        for (int i = 0; i < n; i ++){
            
            
            System.out.print("Inserisci il " + (i + 1) + "° numero: ");
            
            int numeroInput = input.nextInt();

            
            int riga = numeroInput / 100;
            System.out.print(riga);
            int colonna = (numeroInput - (riga * 100)) /10;
            int numeroDaInserire = numeroInput - (riga * 100) - (colonna * 10);
            
            
            if(riga < 1 || riga > 10){
                System.out.println("La riga inserita non è valida!");
                i --;
            }

            else if(colonna < 1 || colonna > 10){
                System.out.println("La colonna inserita non è valida!");
                i --;
            }
                
            else if(numeroDaInserire < 1 || numeroDaInserire > 10){
                System.out.println("Il numero inserito non è valido!");
                i --;
            }
            
            else if(numeroInput == 999){
                i --;
            }
            
            else{
                sudoku[riga - 1][colonna - 1] = numeroDaInserire;
                
                System.out.println("\n");
                s.printSudoku(sudoku);
                System.out.println("\n");
                
            }
  
        }
        
        System.out.println("La soluzione è: ");

        s.solve(sudoku);
        
        s.printSudoku(sudoku);
         
    }
    
}
