import java.util.InputMismatchException;
import java.util.Scanner;

public class calculater {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------ calculater ------------------------------------");

        int choice;
        int addition = 0;
        int subtraction = 0;
        int multiplication = 0;
        int division = 0;
        int modulus = 0;
        int minimum = 0;
        int maximum = 0;
        int average = 0;

        try {

        System.out.println("Enter your first number:");
        int number1 = input.nextInt();

        System.out.println("Enter your second number: ");
        int number2 = input.nextInt();

        input.nextLine();


            do{
                System.out.println
                (
                            "Enter 1 to addition the numbers\n" +
                            "Enter 2 to subtraction the numbers\n" +
                            "Enter 3 to multiplication the numbers\n" +
                            "Enter 4 to division the numbers\n" +
                            "Enter 5 to modulus the numbers\n" +
                            "Enter 6 to find minimum number\n" +
                            "Enter 7 to find maximum number\n" +
                            "Enter 8 to find the average of numbers\n" +
                            "Enter 9 to print the last result in calculator\n" +
                            "Enter 10 to print the list of all results in calculator"

                );
                choice = input.nextInt();

                switch (choice){
                    case 1:
                        addition = number1 + number2;
                        System.out.println("addition:"+addition);
                        break;

                    case 2:
                        subtraction = number1 - number2;
                        System.out.println("subtraction:"+subtraction);
                        break;

                    case 3:
                        multiplication = number1 * number2;
                        System.out.println("multiplication:"+multiplication);
                        break;

                    case 4:
                        if(number2 == 0){
                            System.out.println("you can't divide by zero");
                        }else{
                            division = number1/number2;
                            System.out.println("division:"+division);
                        }
                        break;

                    case 5:
                        modulus = number1 % number2;
                        System.out.println("modulus:"+modulus);
                        break;

                    case 6:
                       maximum = checkMaximum(number1,number2);
                        System.out.println("maximum:"+ maximum);
                        break;

                    case 7:
                        minimum = checkMinimum(number1,number2);
                        System.out.println("minimum:"+ minimum);
                        break;

                    case 8:
                        average = (number1 + number2) / 2;
                        System.out.println("average:"+ average);
                        break;

                    case 9:
                        System.out.println("last result in the calculater is");
                        break;

                    case 10:
                        System.out.println(
                                "List of all results in the calculator:\n" +
                                        "Addition: " + addition + "\n" +
                                        "Subtraction: " + subtraction + "\n" +
                                        "Multiplication: " + multiplication + "\n" +
                                        "Division: " + division + "\n" +
                                        "Modulus: " + modulus + "\n" +
                                        "Minimum: " + minimum + "\n" +
                                        "Maximum: " + maximum + "\n" +
                                        "Average: " + average
                        );
                        break;
                }

            }while(choice != 10);

        }catch(InputMismatchException e) {
            System.out.println("only integers plese");
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("end of program ");
        }


    }



            /// maximum value:
public static int checkMaximum(int num1, int num2){
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
}

 /// maximum value:
    public static int checkMinimum(int num1, int num2){
        if(num1 < num2){
            return num1;
        }else{
            return num2;
        }
    }
}