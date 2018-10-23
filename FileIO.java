import java.util.*;
import java.io.*;
public class FileIO
{
    public static LinkedList<String> read( String inFilename )
    {
        BufferedReader buffered = null;
        String line;
        LinkedList<String> lines = new LinkedList<String>();
        int lineNum;
        try
        {
            buffered = new BufferedReader(new FileReader(inFilename));

            line = buffered.readLine();
            while( line != null )
            {
                lines.insertLast(line);
                line = buffered.readLine();
            }
            buffered.close();
        }
        catch( IOException e)
        {
            if( buffered != null )
            {
                try
                {
                    buffered.close();
                }
                catch( IOException ex2 )
                {
                    System.out.println( e.getMessage() );
                }
            }
            System.out.println("Error!" + e.getMessage() );
        }
        return lines;
    }

    public static void write(String inFilename,LinkedList<String> lines)
    {
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(inFilename);
            for(String line: lines)
            {
                fw.write(line + "\n");
            }
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void save(Object inObj,String inFileName)
    {
        ObjectOutputStream oStream = null;
        try
        {
            oStream = new ObjectOutputStream(new FileOutputStream(inFileName));
            oStream.writeObject(inObj);
            oStream.close();
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to save object");
        }
    }

    public static Object load(String inFileName)
    {
        ObjectInputStream oStream = null;
        Object inObj = null;
        try
        {
            oStream = new ObjectInputStream(new FileInputStream(inFileName));
            inObj = oStream.readObject();
            oStream.close();
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to load Object");
        }
        return inObj;
    }
}
