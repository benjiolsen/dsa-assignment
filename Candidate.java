/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: Candidate
    PURPOSE: To store the candidate data from the Electoral Commission data
             scraped from the csv file. Used for the DSA Assignment
*/
public class Candidate{
    // Private classfields
    private String fName;
    private String sName;
    private String state;
    private String division;
    private String shortParty;
    private String longParty;
    private int divisionID;
    private int candidateID;
    private boolean elected;
    private boolean historic;

    // Getters for all the classfields
    public String getFName(){return fName;}
    public String getSName(){return sName;}
    public String getState(){return state;}
    public String getDivision(){return division;}
    public String getShortParty(){return shortParty;}
    public String getLongParty(){return longParty;}
    public int getDivisionID(){return divisionID;}
    public int getCandidateID(){return candidateID;}
    public boolean getElected(){return elected;}
    public boolean getHistoric(){return historic;}

    public Candidate(String[] candidateData){
        setFName(candidateData[7]);
        setSName(candidateData[6]);
        setState(candidateData[0]);
        setDivision(candidateData[2]);
        setShortParty(candidateData[4]);
        setLongParty(candidateData[3]);
        setDivisionID(Integer.parseInt(candidateData[1]));
        setCandidateID(Integer.parseInt(candidateData[5]));
        setElected(candidateData[8].charAt(0));
        setHistoric(candidateData[9].charAt(0));
    }

    // Setters for all the classfields
    // All string based setters call the testNull to ensure string validity
    // All int setters assume validity
    // Boolean setters test whether it is Y or N for true and false
    // Exceptions are thrown for invalid inputs, to be caught when used
    // (UP THE STACKTRACE)
    public void setFName(String inString){
        if(testNull(inString)==false){
            fName = inString;
        }
        else{
            throw new IllegalArgumentException("Invalid Given Name");
        }
    }
    public void setSName(String inString){
        if(testNull(inString)==false){
            sName = inString;
        }
        else{
            throw new IllegalArgumentException("Invalid Last Name");
        }
    }
    public void setState(String inString){
        if(testNull(inString)==false){
            state = inString;
        }
        else{
            throw new IllegalArgumentException("Invalid State");
        }
    }
    public void setDivision(String inString){
        if(testNull(inString)==false){
            division = inString;
        }
        else{
            throw new IllegalArgumentException("Invalid Division Name");
        }
    }
    public void setShortParty(String inString){
        if(testNull(inString)==false){
            shortParty = inString;
        }
        else{
            System.out.println(inString);
            throw new IllegalArgumentException("Invalid Party Name (Short)");
        }
    }
    public void setLongParty(String inString){
        if(testNull(inString)==false){
            longParty = inString;
        }
        else{
            throw new IllegalArgumentException("Invalid Party Name (Long)");
        }
    }
    public void setDivisionID(int inInt){
        divisionID = inInt;
    }
    public void setCandidateID(int inInt){
        candidateID = inInt;
    }
    public void setElected(char inChar){
        if(inChar == 'Y'){
            elected = true;
        }
        else if(inChar == 'N'){
            elected = false;
        }
        else{
            throw new IllegalArgumentException("Invalid Election Status");
        }
    }
    public void setHistoric(char inChar){
        if(inChar == 'Y'){
            historic = true;
        }
        else if(inChar == 'N'){
            historic = false;
        }
        else{
            throw new IllegalArgumentException("Invalid Historic Status");
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
}
