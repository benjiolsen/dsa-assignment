/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: IteratorTest
    PURPOSE: To act as a test harness for the iterator inside of the linked
             list class. Tests the core functionality of the iterator and
             returns the amount of tests passed.
    REFERENCES: Previously submitted alongside previous practicals to test the
                same functionality.
*/
import java.util.*;
public class IteratorTest
{
    public static void main(String[] args)
    {
        int iNumPassed = 0;
        int iNumTests = 0;
        LinkedList<String> linked = new LinkedList<String>();
        Iterator iter = null;

        System.out.print("\nTesting the constructor: ");
        try
        {
            iNumTests++;
            iter = linked.iterator();
            System.out.println("Passed");
            iNumPassed++;
        } catch(Exception e) { System.out.println("Failed"); }

        System.out.print("\nTesting hasNext() on empty: ");
        try
        {
            iNumTests++;
            if(iter.hasNext()==true)
            { throw new IllegalArgumentException("Failed"); }
            System.out.println("Passed");
            iNumPassed++;
        } catch(Exception e) { System.out.println("Failed"); }

        linked.insertFirst("abc");
        linked.insertFirst("def");
        linked.insertFirst("ghi");

        System.out.print("\nTesting hasNext() on full: ");
        try
        {
            iNumTests++;
            iter = linked.iterator();
            if(iter.hasNext() == false)
            { throw new IllegalArgumentException("Failed"); }
            System.out.println("Passed");
            iNumPassed++;
        } catch(Exception e) { System.out.println("Failed"); }

        System.out.print("\nTesting next(): ");
        try
        {
            iNumTests++;
            if(iter.next() == null)
            { throw new IllegalArgumentException("Failed"); }
            System.out.println("Passed");
            iNumPassed++;
        } catch(Exception e) { System.out.println("Failed"); }

        System.out.println( "\n" + iNumPassed + "/" + iNumTests );

    }
}
