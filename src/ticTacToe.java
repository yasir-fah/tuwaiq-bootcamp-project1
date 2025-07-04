import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();


        // create the matrix of the:
        String[][] ticTacToeMatrix = new String[3][3];

        System.out.println("chose X or O:");
        String userChoice = input.nextLine(); //e.g  X

        int counter = 0 ;
        int userRow;
        int userCol;
        boolean win = false;


        // make it empty matrix until user add position
        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix.length; j++) {
                ticTacToeMatrix[i][j] = " ";
            }
        }

        do {

            /// display the board
            displayBoard(ticTacToeMatrix);

            //add user choice:
            System.out.println("chose your index [row][column], first row:");
            userRow = input.nextInt();

            System.out.println("chose your index [row][column], now column:");
            userCol = input.nextInt();

            ticTacToeMatrix[userRow][userCol] = userChoice;


            ///check validate:
            if(counter >= 2){
               win =  isWin(ticTacToeMatrix,userChoice);
            }

            counter++;
        } while (!win);


    }


//    public static boolean checkValidPos(String input) {
//
//        return true;
//    }

    public static boolean isWin(String[][] matrix, String choice) {
        int counterHorizontal = 0;
        int counterVertical   = 0;
        int counterDiagonal1  = 0;
        int counterDiagonal2  = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //1- Horizontal
                if(matrix[i][j].contains(choice)){
                    counterHorizontal++; // counter = 3 => win.
                }else{
                    counterHorizontal = 0;
                }
                //2- vertical
                if(matrix[j][i].contains(choice)){
                    counterVertical++;
                }else{
                    counterVertical = 0;
                }
                //3- diagonal
                if(i == j){
                   if(matrix[i][j].contains(choice)){
                       counterDiagonal1++;
                   }
                }else if(i+2 == 2){
                    if(matrix[i][j].contains(choice)){
                        counterDiagonal2++;
                    }
                }

                //when reach to end of a row and no win
                if(j == 2){
                    if(counterVertical <3){
                        counterVertical = 0;
                    }
                }
            }

            //when reach to end of a column and no win
            if(i == 2){
                if(counterHorizontal < 3){
                    counterHorizontal = 0;
                }
            }

            // when player hit a line and win
            if(counterHorizontal == 3){
                System.out.println("win !, horizontally");
                return true;

            }else if(counterVertical == 3){
                System.out.println("win !, vertically");
                return true;
            }else if(counterDiagonal1 == 3){
                System.out.println("win !, diagonally");
                return true;
            }else if(counterDiagonal2 == 3){
                System.out.println("win !, diagonally");
                return true;
            }

        }
       return false;
    }



    public static String[][] displayBoard(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j < matrix.length - 1) {
                    System.out.print("("+i+","+j+")"+(matrix[i][j])+" | ");
                }
                else {
                    System.out.print("("+i+","+j+")"+(matrix[i][j]));
                }
            }
            // new line
            System.out.println();
        }
        return matrix;
    }


}
