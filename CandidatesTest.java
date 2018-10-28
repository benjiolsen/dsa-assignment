/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: SeatsTest
    PURPOSE: To act as a test harness for the candidate class. This tests the
             base functionality of the container class, the storing and
             retreival of the information, and the ability to reject bad
             data
*/
import java.util.*;
public class CandidatesTest{
    public static void main(String[] args){
        int iNumPassed = 0;
        int iNumTests = 0;
        Candidate can = null;
//---
        System.out.println("Testing the constructor");
        try{
            iNumTests++;
            String[] data = {"WA",
                             "234",
                             "Cowan",
                             "The Greens",
                             "ALP",
                             "19481681",
                             "Galati",
                             "Tony",
                             "Y",
                             "N"};
            can = new Candidate(data);
            if(can.getDivisionID()!=234)
            {throw new Exception();}
            iNumPassed++;
            System.out.println("Passed\n");
        } catch(Exception e) { System.out.println("Failed\n"); }
//---
        System.out.println("Testing the constructor with bad data");
        try{
            iNumTests++;
            String[] data = {"",
                             "95872e65928376459823765",
                             "",
                             "",
                             "",
                             "19481681234234234234234234",
                             "",
                             "",
                             "A",
                             "4"};
            can = new Candidate(data);
            System.out.println("Failed\n");
        } catch(Exception e){
            iNumPassed++;
            System.out.println("Passed\n");
        }
        System.out.println(iNumPassed + "/" + iNumTests);
    }
}
