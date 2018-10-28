/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: SeatsTest
    PURPOSE: To act as a test harness for the File IO class. This tests the
             functionality used for the assignment, the reading and writing
             of files.
*/
import java.util.*;
public class FileIOTest{
    public static void main(String args[]){
        int iNumPassed = 0;
        int iNumTests = 0;
        LinkedList<String> list = new LinkedList<String>();

        System.out.println("Testing the file reading");
        try{
            iNumTests++;
            list = FileIO.read("FileIO.java");
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
            if(!list.peekFirst().equals("    PURPOSE: Handles all the file input output using Object serialisation or"))
            {throw new Exception();}
            iNumPassed++;
            System.out.println("Passed\n");
        } catch(Exception e) { System.out.println("Failed\n"); }

        System.out.println("Testing the file saving");
        try{
            iNumTests++;
            FileIO.write("iotest.txt",list);
            iNumPassed++;
            System.out.println("Passed\n");
        } catch(Exception e) { System.out.println("Failed\n"); }
        System.out.println(iNumPassed + "/" + iNumTests);
    }
}
