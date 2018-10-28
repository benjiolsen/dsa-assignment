import java.text.*;
public class Seats{
    private double margin;
    private String divisionNm;
    private int divisionID;

    // Default constructor calls the relevant setters
    public Seats(double inMargin,String inDivisionNm,int inDivisionID)
    {
        setMargin(inMargin);
        setDivisionNm(inDivisionNm);
        setDivisonID(inDivisionID);
    }

    // Public getters
    public double getMargin(){return margin;}
    public String getDivisionNm(){return divisionNm;}
    public int getDivisionID(){return divisionID;}

    // Public setters
    public void setMargin(double inMargin){
        margin = inMargin;
    }
    public void setDivisonID(int inDivisionID){
        divisionID = inDivisionID;
    }
    public void setDivisionNm(String inDivisionNm){
        if(testNull(inDivisionNm)==false){
            divisionNm = inDivisionNm;
        }
        else{
            System.out.println(inDivisionNm);
            throw new IllegalArgumentException("Invalid Division Name");
        }
    }

    // Ensures the string isnt null or empty
    private boolean testNull(String inString){
        boolean isNull = true;
        if(inString != null && !inString.equals("")){
            isNull = false;
        }
        return isNull;
    }

    public String toString(){
        String output = new String();
        DecimalFormat df = new DecimalFormat(".00");
        output += "Division: " + divisionNm;
        output += " ID: " + divisionID;
        output += " Margin Percentage: " + df.format(margin) + "%";
        return output;
    }
}
