import java.util.*;
public class menu{
    public static void run()
    {
        int choice = 1;
        while(choice > 0 && choice <= 4)
        {
            System.out.println("Please enter a number as your selection");
            System.out.println("[1] List Nominees\n[2] Nominee Search\n"+
                               "[3] List by Margin\n[4] Itenerary by Margin"+
                               "\n[0] Exit");
            choice = userInput.intPut(0,4);
            select(choice);
        }
        System.out.println("Bye!");
    }

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
