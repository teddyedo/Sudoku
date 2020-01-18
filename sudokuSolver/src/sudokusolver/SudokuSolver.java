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
 * @version 1.1.0 - 18/01/2020
 *
 */
public class SudokuSolver {

    public static int row = 9;
    public static int col = 9;
    public static int[][] sudoku = new int[row][col];

    public static void main(String[] args) {

        solver s = new solver();
        Scanner input = new Scanner(System.in);

        
        //intialize an empty table
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                sudoku[i][j] = 0;

            }
        }

        //input phase
        boolean confirm = false;
        int numeri = 0;

        while (!confirm) {
            System.out.print("Quanti numeri ci sono già inseriti nel sudoku che "
                    + "vuoi risolvere? ");

            int n = input.nextInt();

            System.out.print("Hai inserito il numero " + n + ";\n"
                    + "Se il numero è corretto, digita 1 e premi invio, altrimenti "
                    + "digita 0 e reinserisci il numero di valori che compongono "
                    + "il tuo sudoku: ");
            
            
            int m = input.nextInt();
            switch (m) {
                case 1:
                    confirm = true;
                    numeri = n;
                    break;
                case 0:
                    confirm = false;
                    break;
                default:
                    System.out.println("E' stato inserito un valore non valido!");
                    break;
            }
            
        }
        
        

        System.out.println("\nInserisci i numeri presenti nello schema che vuoi "
                + "risolvere secondo il seguente schema: RCN, dove: \n\n"
                + "R -> Riga \n"
                + "C -> Colonna \n"
                + "N -> Numero \n"
                + "\nAd esempio 846 significa alla riga 8, colonna 4, metti il 6"
                + "\n"
                + "\nN.B. Se ci si accorge di aver sbagliato l'inserimento di un "
                + "numero, inserire il codice 999, premere invio e proseguire "
                + "con l'inserimento dei numeri.\n");
        
        
        int ultimaRow = 0;
        int ultimaCol = 0;

        //Here the user put his value into the board; when the last value is 
        //inserted, the sudoku is calculated and printed out.
        for (int i = 0; i < numeri; i++) {

            System.out.print("Inserisci il " + (i + 1) + "° numero: ");

            int numeroInput = input.nextInt();

            //get the value of row, column and number from the 3 digits value 
            //inserted by the user
            int riga = numeroInput / 100;
            System.out.print(riga);
            int colonna = (numeroInput - (riga * 100)) / 10;
            int numeroDaInserire = numeroInput - (riga * 100) - (colonna * 10);

            
            //check if the value of row, column and number is valid; if it isn't,
            //the value is discarded and the operation is repeated
            if (riga < 1 || riga > 10) {
                System.out.println("La riga inserita non è valida!");
                i--;
            } 
            
            else if (colonna < 1 || colonna > 10) {
                System.out.println("La colonna inserita non è valida!");
                i--;
            } 
            
            else if (numeroDaInserire < 1 || numeroDaInserire > 10) {
                System.out.println("Il numero inserito non è valido!");
                i--;
            } 

            //if the user want to delete the last inserted value, he have to digit 999
            else if (numeroInput == 999) {           
                sudoku[ultimaRow - 1][ultimaCol - 1] = 0;         
                i--;
                i--;
            }

            //every time that a value is inserted, the program print the table
            //updated
            else {
                sudoku[riga - 1][colonna - 1] = numeroDaInserire;

                ultimaRow = riga;
                ultimaCol = colonna;
                
                System.out.println("\n");
                s.printSudoku(sudoku);
                System.out.println("\n");

            }

        }

        System.out.println("La soluzione è: \n\n");

        s.solve(sudoku);

        s.printSudoku(sudoku);

    }

}
