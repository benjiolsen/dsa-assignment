/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: LinkedListTest
    PURPOSE: To act as a test harness for the linked list class. This tests
             core functionality and returns the pass rate as a percentage
    REFERENCES: Previously submitted alongside previous practicals to test the
                same functionality.
*/
import java.io.*;
public class LinkedListTest
{
    public static void main(String args[])
    {
        int iNumPassed = 0;
        int iNumTests = 0;
        LinkedList<String> linked = null;
        String testString;
        Object nodevalue;

        System.out.println("Testing the constructor");
        try
        {
            iNumTests++;
            linked = new LinkedList<String>();
            System.out.print("Testing isEmpty(): ");
            if(linked.isEmpty()==false)
            { throw new IllegalArgumentException("Head must be null"); }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }

//----
        System.out.println("\nTesting the stack behaviour");
        try
        {
            iNumTests++;
            System.out.print("Testing insertFirst(): ");
            linked.insertFirst("abc");
            linked.insertFirst("def");
            linked.insertFirst("ghi");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }
        try
        {
            iNumTests++;
            System.out.print("Testing peekLast(): ");
            testString = linked.peekLast();
            if(testString != "abc")
            { throw new IllegalArgumentException("Failed"); }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }
        try
        {
            iNumTests++;
            System.out.print("Testing removeFirst(): ");
            testString = linked.removeFirst();
            if(testString != "ghi")
            { throw new IllegalArgumentException("Failed"); }
            testString = linked.removeFirst();
            if(testString != "def")
            { throw new IllegalArgumentException("Failed"); }
            testString = linked.removeFirst();
            if(testString != "abc")
            { throw new IllegalArgumentException("Failed"); }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }

        try
        {
            iNumTests++;
            System.out.print("Testing isEmpty(): ");
            testString = linked.removeFirst();
            System.out.println("Failed");
        } catch(Exception e) { iNumPassed++; System.out.println("passed"); }

//-----
        System.out.println("\nTesting Queue behaviour");
        try
        {
            iNumTests++;
            System.out.print("Testing insertLast(): ");
            linked.insertLast("abc");
            linked.insertLast("def");
            linked.insertLast("ghi");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }
        try
        {
            iNumTests++;
            System.out.print("Testing peekFirst(): ");
            testString = linked.peekFirst();
            if(testString != "abc")
            { throw new IllegalArgumentException("Failed"); }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }
        try
        {
            iNumTests++;
            System.out.print("Testing removeFirst(): ");
            testString = linked.removeFirst();
            if(testString != "abc")
            { throw new IllegalArgumentException("Failed"); }
            testString = linked.removeFirst();
            if(testString != "def")
            { throw new IllegalArgumentException("Failed"); }
            testString = linked.removeFirst();
            if(testString != "ghi")
            { throw new IllegalArgumentException("Failed"); }
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("Failed"); }

        try
        {
            iNumTests++;
            System.out.print("Testing isEmpty(): ");
            testString = linked.removeFirst();
            System.out.println("Failed");
        } catch(Exception e) { iNumPassed++; System.out.println("passed"); }

        try
        {
            iNumTests++;
            System.out.print("Testing insertFirst(): ");
            linked.insertFirst("abc");
            linked.insertFirst("def");
            linked.insertFirst("ghi");
            iNumPassed++;
        } catch(Exception e){ System.out.println("Failed"); }

        System.out.println(iNumPassed + "/" + iNumTests);
    }
}
