package datastarter;

import static java.awt.PageAttributes.MediaType.D;
import java.util.*;
import java.io.*;

/**
 * This program reads in a .csv file and randomly selects lines in it 
 * to remove. It then creates a new file with the reduced data set.
 * 
 * @author Alex Santos-Urbina
 */
public class DataStarter {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader reader = null;
        String blankLine = "";
        String writeLine = "";
        
        //create new file with reduced dataset
        FileWriter newFile = new FileWriter(new File("D:\\Netbeans Projects\\DataStarter", "movies_reduced.csv"));
        BufferedWriter writer = new BufferedWriter(newFile);
        PrintWriter output = new PrintWriter(writer);
        
        //read in the csv file
        reader = new BufferedReader(new FileReader("tmdb_5000_movies.csv"));
        output.println(reader.readLine());
        
        //randomly select and remove half of the lines in the file
        while ((blankLine = reader.readLine()) != null) 
        {
            writeLine = reader.readLine();
            
            if (((int) (Math.random() * 2)) == 1)
                output.println(blankLine);
            else 
                output.println(writeLine);
        }
    }
}
