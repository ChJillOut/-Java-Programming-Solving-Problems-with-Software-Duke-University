
/**
 * Write a description of averageTemperatureWithHighHumidityInFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class averageTemperatureWithHighHumidityInFile {
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        int count = 0;
        double sum = 0;
        for (CSVRecord currentRow : parser) {
            String humidity = currentRow.get("Humidity");
            if (!humidity.equals("N/A")) {
                double Humidity = Double.parseDouble(currentRow.get("Humidity"));
                double Temperature = Double.parseDouble(currentRow.get("TemperatureF"));
                if (Humidity >= value) {
                    count = count + 1;
                    sum = Temperature + sum;
                }
            }
            
        }
        return sum/count;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureWithHighHumidityInFile(parser,80);
        if (Double.isNaN(averageTemp)) {
            System.out.println("No temperatures with that humidity");
        }
        else {
            System.out.println("Average Temp when high Humidity is " + averageTemp);
        }
        
    }

}
