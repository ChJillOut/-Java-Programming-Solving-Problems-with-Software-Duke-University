
/**
 * Write a description of coldestHourInFile here.
 * 
 * @author (Jill Liu) 
 * @version (01/17/2018)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class coldestHourInFile {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord lowestSoFar =  null;
        for (CSVRecord currentRow: parser) {
            lowestSoFar = getLargestOfTwo(currentRow,lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public CSVRecord coldestInManyDays() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            lowestSoFar = getLargestOfTwo(currentRow,lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord lowestSoFar) {
        
        if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            if (currentTemp < lowestTemp && currentTemp != -9999) {
                    lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("TimeEDT"));
    }
    
    public String fileWithColdestTemperature() {
        CSVRecord lowestSoFar = null;
        File lowestFile = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            lowestSoFar = getLargestOfTwo(currentRow,lowestSoFar);
            lowestFile = f;
        }
        return lowestFile.getName();
    }
    
    public void testFileWithColdestTemperature() {
        String lowestFile = fileWithColdestTemperature();
        FileResource fr = new FileResource(lowestFile);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestSoFar = coldestHourInFile(parser);
        System.out.println("Coldest day was in file "+ lowestFile);
        System.out.println("Coldest temperature on that day was " + lowestSoFar.get("TemperatureF"));
        for (CSVRecord record : parser) {
              System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if(lowestSoFar == null) {
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
    
        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
        
    
    
}

        
 
    
    
    


