
/**
 * Write a description of ParsingExportData here.
 * 
 * @author (Jill Liu) 
 * @version (01/17/2018)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class ParsingExportData {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");
        
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"cotton","flowers");
        
        parser = fr.getCSVParser();
        int numberOfExporters = numberOfExporters(parser, "cocoa");
        System.out.println(numberOfExporters);
        
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
    
    public void countryInfo(CSVParser parser, String country){
        for (CSVRecord record : parser) {
            String selectedCountry = record.get("Country");
            if (selectedCountry.contains(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println(country+": "+exports+": "+value);
            }
        }
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
            String country = record.get("Country");
            System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)){
                count = count + 1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                String country = record.get("Country");
                String dollar = record.get("Value (dollars)");
                System.out.println(country+" "+dollar);
            }
        }
      
    }
}
