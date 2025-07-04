import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

// if user chose a position that already taken before.
        // create the matrix of the:
        String[][] ticTacToeMatrix = new String[3][3];

        System.out.println("chose X or O:");
        String userChoice = input.nextLine(); //e.g  X

        int counter = 0 ;
        boolean win = false;
        boolean validPos = false;
        String computerVariable;

        int userRow;
        int userCol;

        int compRow;
        int compCol;


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
            do {

                System.out.println("chose your index [row][column], first row:");
                userRow = input.nextInt();

                System.out.println("chose your index [row][column], now column:");
                userCol = input.nextInt();

                /// if is valid or not:
                    validPos = isValidPos(ticTacToeMatrix, userRow, userCol);
                    if (!validPos) {
                        System.out.println("user chose taken place ");
                    }


            }while(!validPos);


            //position confirmed
            ticTacToeMatrix[userRow][userCol] = userChoice;


            ///check win or not:
            if(counter >= 2){
                win =  isWin(ticTacToeMatrix,userChoice,counter);
                if(win){
                    System.out.println("user wins");
                    break; // end loop
                }
            }
            counter++;

            //determine a letter for computer:
            if(userChoice.toLowerCase().replace(" ","").contains("x")){
                computerVariable = "O";
            }else{
                computerVariable = "X";
            }

            do {
                compRow = (int)(Math.random() * 3);
                compCol = (int)(Math.random() * 3);


                    validPos = isValidPos(ticTacToeMatrix, compRow, compCol);
                    if (!validPos) {
                        System.out.println("computer chose taken place ");
                    }



            }while(!validPos);

            ticTacToeMatrix[compRow][compCol] = computerVariable;

            if(counter >= 2){ // call the method only when there is chance of win.
                win =  isWin(ticTacToeMatrix,computerVariable,counter);
                if (win){
                    break; //end loop
                }
            }

        counter++;
        } while (!win);
        displayBoard(ticTacToeMatrix);

    }


    public static boolean isValidPos(String[][] matrix,int row, int col) {
        if(
                matrix[row][col].toLowerCase().contains("x") ||
                        matrix[row][col].toLowerCase().contains("o")
        ){
            System.out.println("this position is taken, please chose another:");
            return false;
        }

        return true;
    }


    public static boolean isWin(String[][] matrix, String choice, int counter) {
        int counterHorizontal = 0;
        int counterVertical   = 0;
        int counterDiagonal1  = 0;
        int counterDiagonal2  = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //1- Horizontal
                if (matrix[i][j].contains(choice)) {
                    counterHorizontal++; // counter = 3 => win.
                }
                else {
                    counterHorizontal = 0;
                }
                //2- vertical
                if (matrix[j][i].contains(choice)) {
                    counterVertical++;
                }
                else {
                    counterVertical = 0;
                }
                //3- diagonal
                if (i == j) {
                    if (matrix[i][j].contains(choice)) {
                        counterDiagonal1++;
                    }
                }
                else if (i + 2 == 2) {
                    if (matrix[i][j].contains(choice)) {
                        counterDiagonal2++;
                    }
                }

                //when reach to end of a row and no win
                if (j == 2) {
                    if (counterVertical < 3) {
                        counterVertical = 0;
                    }
                }
            }

            //when reach to end of a column and no win
            if (i == 2) {
                if (counterHorizontal < 3) {
                    counterHorizontal = 0;
                }
            }

            // when player hit a line and win
            if (counterHorizontal == 3) {
                System.out.println("win !, horizontally");
                return true;
            }
            else if (counterVertical == 3) {
                System.out.println("win !, vertically");
                return true;
            }
            else if (counterDiagonal1 == 3) {
                System.out.println("win !, diagonally");
                return true;
            }
            else if (counterDiagonal2 == 3) {
                System.out.println("win !, diagonally");
                return true;
            }
            else if (counter >= 9) { // to detect the draw
                System.out.println("draw");
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