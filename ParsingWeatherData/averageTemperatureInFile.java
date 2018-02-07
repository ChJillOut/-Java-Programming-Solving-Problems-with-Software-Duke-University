
/**
 * Write a description of averageTemperatureInFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class averageTemperatureInFile {
    public double averageTemperatureInFile(CSVParser parser) {
        int count = 0;
        double sum = 0;
        for (CSVRecord currentRow : parser) {
            count = count + 1; 
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            sum = sum + currentTemp;
        }
        return sum/count;
    }
    
    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+ averageTemp);
    
    }
}
