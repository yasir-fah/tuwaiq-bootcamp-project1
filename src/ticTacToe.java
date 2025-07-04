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
        int counterHorizental = 0;
        int counterVertical   = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j].contains(choice)){
                    counterHorizental++; // counter = 3 => win.
                }else{
                    counterHorizental = 0;
                }
                if(matrix[j][i].contains(choice)){
                    counterVertical++;
                }else{
                    counterVertical = 0;
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
                if(counterHorizental < 3){
                    counterHorizental = 0;
                }
            }

            // when player hit a line and win
            if(counterHorizental == 3){
                System.out.println("win !");
                return true;

            }else if(counterVertical == 3){
                System.out.println("win !");
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
