/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: UserInput
    PURPOSE: To handle general user input of real and integer numbers and
             Strings for the DSA Assignment
*/
import java.util.*;
public class UserInput{

    // intPut
    // Handles integer input from the user, within a specified range
    public static int intPut(int min,int max){
        // Creates the scanner object
        Scanner sc = new Scanner(System.in);
        // Ensures the number is out of the loop so that it may begin looping
        int input = min-1;
        try{// Trys to take in the input, if there is an error, it is caught
            while(input < min || input > max){
                // Above loops until it is in the range
                System.out.println("Please input a number between "+ min +
                                   " and " + max);
                if(sc.hasNextInt()){// Detects if there is an integer
                    input = sc.nextInt();
                }
                else{// Otherwise flushes it
                    sc.next();
                }
            }
        }
        catch(InputMismatchException e){
            // Catches and prints the caught exception
            System.out.println("Please input an integer");
        }
        return input;
    }

    // stringPut
    // Handles String input from the user
    public static String stringPut(){
        // Creates the Scanner Object
        Scanner sc = new Scanner(System.in);
        String input = new String();
        try{// Trys to take the inpout, and catches the thrown exception
            System.out.println("Please enter your string below:");
            if(sc.hasNext()){
                // Ensures something was input (semi pointless)
                input = sc.next();
            }
            else{// Flushes
                sc.next();
            }
        }catch(InputMismatchException e){// Prints an error message
            System.out.println("Please input a String");
        }
        return input;
    }

    // doublePut
    // Handles double input from the user, within a specified range
    public static double doublePut(double min,double max){
        Scanner sc = new Scanner(System.in);
        double input = min-1;
        try{
            // Trys to take in the user input and catches the exception if thrown
            while(input < min || input > max){
                // Loops until the input is in the right range
                System.out.println("Please input a number between "+ min +
                                   " and " + max);
                if(sc.hasNextDouble()){
                    // Checks to see if the input was a double
                    input = sc.nextDouble();
                }
                else{// Otherwise flushes and goes back to the top of the loop
                    sc.next();
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please input a valid real number");
        }
        return input;
    }
}
