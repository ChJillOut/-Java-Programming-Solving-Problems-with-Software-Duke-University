
/**
 * Write a description of lowestHumidityInFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class lowestHumidityInFile {
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            lowestSoFar = getLargestOfTwo (currentRow, lowestSoFar);
        }
        return lowestSoFar;
    }
   
    public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord lowestSoFar) {
        
        if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        }
        else {
            String humidity = currentRow.get("Humidity");
            if (!humidity.equals("N/A")) {
                double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                if (currentHumidity < lowestHumidity) {
                    lowestSoFar = currentRow;
                }
            }
        }
        return lowestSoFar;
    }

    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestSoFar = null; 
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = getLargestOfTwo(currentRow, lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInManyFiles() {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
}
