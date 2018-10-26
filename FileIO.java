/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: FileIO
    PURPOSE: Handles all the file input output using Object serialisation or
             the LinkedList Data Structure to store the lines being read in
             or saved, and uses the serializable function in objects to be
             able to save them to file.
    REFERENCES: Previously submitted in various practicals, constantly being
                worked on and updated throughout. Benjamin Olsen 19481681
*/
import java.util.*;
import java.io.*;
public class FileIO
{
    // read
    // This function takes in a filename and reads each line into a linked
    // list, and then returns the list back to the calling function. The list
    // is created here and returned as it saves passing the list into this
    // function, and all that needs to be known is it takes in a filename
    public static LinkedList<String> read( String inFilename ){
        // Creates the buffered reader outside so it doesnt come up as
        // unitialised
        BufferedReader buffered = null;
        // Is the string to represent the line in the file
        String line;
        // Creates the list the line is read into
        LinkedList<String> lines = new LinkedList<String>();
        try{
            // Creates the buffered reader using the file reader using the
            // filename input
            buffered = new BufferedReader(new FileReader(inFilename));
            // Reads the first line in
            line = buffered.readLine();
            while( line != null ){
                // Loops until the file is empty
                // Inserts the line into the end of the list to ensure the
                // order is preserved
                lines.insertLast(line);
                // Reads in the next line
                line = buffered.readLine();
            }
            // Closes the buffered stream to close the file
            buffered.close();
        }
        catch( IOException e){
            // Catches the I/O exception and handles it
            if( buffered != null ){
                try{// Tries to close the file if it isnt closed
                    buffered.close();
                }
                catch( IOException ex2 ){
                    // Nothing more can be done
                    System.out.println( e.getMessage() );
                }
            }
            // Prints the error
            System.out.println("Error!" + e.getMessage() );
        }
        // Returns the entire list
        return lines;
    }

    // write
    // This function takes in a filename and a linked list of lines to be
    // saved to the file. The linked list ensures that the length is not
    // needed to be used and if the file is read into a linked list,
    // modifications can be made to that list and then saved.
    public static void write(String inFilename,LinkedList<String> lines){
        // Initialises the filewriter to be null so that it doesnt end up
        // uninitalised
        FileWriter fw = null;
        try{
            //Initialises the filewriter using the input filename
            fw = new FileWriter(inFilename);
            // A foreach loop for each string in the linked list
            for(String line: lines){
                // Writes to file with a newline character to ensure spacing
                fw.write(line + "\n");
            }
            // Ensures the stream is closed
            fw.close();
        }
        catch( IOException e){
            // Catches the I/O exception and handles it
            if( fw != null ){
                try{// Tries to close the file if it isnt closed
                    fw.close();
                }
                catch( IOException ex2 ){
                    // Nothing more can be done
                    System.out.println( e.getMessage() );
                }
            }
            // Prints the error
            System.out.println("Error!" + e.getMessage() );
        }
    }

    // save
    // This function handles all the Object serialisation. Taking in the
    // object and its filename it then seralises it and saves the data into
    // the filename provided. Using the object output stream, it saves the
    // objects binary data to file.
    public static void save(Object inObj,String inFileName){
        // Initialises the Object output stream so it is somewhat initialised
        // if it fails in the try catch
        ObjectOutputStream oStream = null;
        try{
            // Creates the stream, puts the info in, and then closes the file
            oStream = new ObjectOutputStream(new FileOutputStream(inFileName));
            oStream.writeObject(inObj);
            oStream.close();
        }
        catch(Exception e){
            if(oStream!=null){
                try{// If the file is still open, try to close it
                    oStream.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Unable to save object!");
        }
    }

    // load
    // This function loads in a seralised object using the relevant java IO
    // methods. This function also handles the errrors thrown its way from
    // whatever causes them. As this isnt specific to any object, the Object
    // class, from which all inherit, is used to
    public static Object load(String inFileName){
        // Creates an object to be loaded and its input stream, making them
        // null, incase they dont get initialised from the file
        ObjectInputStream oStream = null;
        Object inObj = null;
        try{
            oStream = new ObjectInputStream(new FileInputStream(inFileName));
            inObj = oStream.readObject();
            oStream.close();
        }
        catch(Exception e){
            if(oStream!=null){
                try{// If the file is still open, try to close it
                    oStream.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Unable to save object!");
        }
        return inObj;
    }
}
