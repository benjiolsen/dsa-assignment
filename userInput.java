import java.util.*;
public class userInput{
    public static int intPut(int min,int max)
    {
        Scanner sc = new Scanner(System.in);
        int input = min-1;
        try{
            while(input < min || input > max)
            {
                System.out.println("Please input a number between "+ min +
                                   " and " + max);
                if(sc.hasNextInt())
                {
                    input = sc.nextInt();
                }
                else
                {
                    sc.next();
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please input an integer");
        }
        return input;
    }
}
