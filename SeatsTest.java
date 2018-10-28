/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: SeatsTest
    PURPOSE: To act as a test harness for the seats class. This tests the
             base functionality of the container class, the storing and
             retreival of the information, and the ability to reject bad
             data
*/
import java.util.*;
public class SeatsTest{
    public static void main(String[] args){
        int iNumPassed = 0;
        int iNumTests = 0;
        Seats seat = null;

        System.out.println("Testing the constructor");
        try
        {
            iNumTests++;
            seat = new Seats(3.0,"Cowan",235);
            if(seat.getDivisionID()!=235)
            {throw new Exception();}
            iNumPassed++;
            System.out.println("Passed\n");
        } catch(Exception e) { System.out.println("Failed\n"); }
//----
        System.out.print("Testing the constructor with bad information");
        try
        {
            iNumTests++;
            seat = new Seats(-333000.0,"",-0);
            System.out.println("Failed\n");
        } catch(Exception e){
            System.out.println("Passed\n");
            iNumPassed++;
        }
//----
        System.out.println("Testing the toString");
        try
        {
            iNumTests++;
            seat = new Seats(3.0,"Cowan",235);
            if(!seat.toString().equals("Division: Cowan ID: 235 Margin Percentage: 3.00%"))
            {throw new Exception();}
            iNumPassed++;
            System.out.println("Passed\n");
        } catch(Exception e) { System.out.println("Failed\n"); }

        System.out.println(iNumPassed + "/" + iNumTests);
    }
}
