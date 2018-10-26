import java.util.*;
public class UserInput{
    public static int intPut(int min,int max){
        Scanner sc = new Scanner(System.in);
        int input = min-1;
        try{
            while(input < min || input > max){
                System.out.println("Please input a number between "+ min +
                                   " and " + max);
                if(sc.hasNextInt()){
                    input = sc.nextInt();
                }
                else{
                    sc.next();
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please input an integer");
        }
        return input;
    }

    public static String stringPut(){
        Scanner sc = new Scanner(System.in);
        String input = new String();
        try{
            System.out.println("Please enter your string below:");
            if(sc.hasNext()){
                input = sc.next();
            }
            else{
                sc.next();
            }
        }catch(InputMismatchException e){
            System.out.println("Please input a String");
        }
        return input;
    }

    public static double doublePut(double min,double max){
        Scanner sc = new Scanner(System.in);
        double input = min-1;
        try{
            while(input < min || input > max){
                System.out.println("Please input a number between "+ min +
                                   " and " + max);
                if(sc.hasNextDouble()){
                    input = sc.nextDouble();
                }
                else{
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
