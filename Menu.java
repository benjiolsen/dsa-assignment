/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: Menu
    PURPOSE: Used to run and call the needed functions for the running of
             the DSA Assignment for 2018 Semester 2. Using switch statements
             and the UserInput class to handle the main menu function.
*/
import java.util.*;
public class Menu{

    // run
    // This is the function that loops constantly to print the main menu out
    // in the CLI. This function shows the user their choices, and calls the
    // function responsible to allow them to chose, then the function call
    // to the select method, which is one big switch statement based upon the
    // users choice on what they would like to do.
    public static void run()
    {
        int choice = 1;
        while(choice > 0 && choice <= 4)
        {
            // Janky print to clear a linux terminal
            System.out.println("\033\143");
            // Asks the user to choose which operation they want
            System.out.println("Please enter a number as your selection");
            System.out.println("[1] List Nominees\n[2] Nominee Search\n"+
                               "[3] List by Margin\n[4] Itenerary by Margin"+
                               "\n[0] Exit");
            // Uses the UserInput class to get the integer input
            choice = UserInput.intPut(0,4);
            select(choice);
        }
        System.out.println("Bye!");
    }

    // select
    // Contains the big switch statement that runs what the user wants to
    // select. This switch runs on the integer choice the user makes, and then
    // if the user selected 0, it breaks from the switch and then out of the
    // main loop, ending the program
    public static void select(int choice)
    {
        switch(choice)
        {
            case 1: choice = 1;
                listNominees();
            break;
            case 2: choice = 2;
                searchNominees();
            break;
            case 3: choice = 3;
                listMargin();
            break;
            case 4: choice = 4;
                itinerary();
            break;
            default:
            break;
        }
    }

    public static void listNominees()
    {

    }
    public static void searchNominees()
    {

    }
    public static void listMargin()
    {

    }
    public static void itinerary()
    {

    }
}
