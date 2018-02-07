
/**
 * Write a description of MiniProjectExercise here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class MiniProjectExercise {
    public void totalBirths (FileResource fr) {
        int totalNames = 0;
        int totalBoyNames = 0;
        int totalGirlNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals("M")) {
                totalBoyNames += 1;
            }
            else {
                totalGirlNames += 1;
            }
            totalNames += 1;
        }
        System.out.println("total names = " + totalNames);
        System.out.println("female girls = " + totalGirlNames);
        System.out.println("male boys = " + totalBoyNames);
    }

    public void testTotalBirths () {
	//FileResource fr = new FileResource();
	FileResource fr = new FileResource();
	totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        for (CSVRecord rec : parser) {
            if (rec.get(1).equals(gender)) {
                rank += 1;
                if (rec.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }
    
    public void testgetRank() {
        int rank = getRank(2012,"Mason", "M");
        System.out.println(rank);  
    }
    
    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int num = 0;
        for (CSVRecord rec : parser) {
            if (rec.get(1).equals(gender)) {
                num +=1;
                if (num == rank) {
                    String name = rec.get(0);
                    return name;
                }
            }
        }
        return "NO NAME";
    }
    
    public void testgetName() {
        String name = getName(2012, 5, "M");
        System.out.println(name);
    
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        if (rank != -1) {
            String newname = getName(newYear, rank, gender);
            System.out.println(name+" born in " + year + " would be "+ newname+" if she was born in " + newYear);
        }
        else {
            System.out.println("NO NAME");
        
        }
    }
    
    public void testwhatIsNameInYear() {
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }
    
    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 0;
        String yob = null;
        int year = 0;
        int highestYear = 0;
        for (File f:dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fName = f.getName();
            yob = fName.substring(3,7);
            year = Integer.parseInt(yob);
            int currentRank = getRank2(year,name, gender,fr);
            if (highestRank == 0) {
                highestRank = currentRank;
            }
            if (currentRank != -1) {
                if (currentRank < highestRank) {
                    highestRank = currentRank;
                    highestYear = year;
                }
            }  
            else {
                return -1;
            }
        }
        return highestYear;
    }
    
        public int getRank2(int year, String name, String gender, FileResource fr) {
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        for (CSVRecord rec : parser) {
            if (rec.get(1).equals(gender)) {
                rank += 1;
                if (rec.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }
    
    public void testyearOfHighestRank() {
        int year = yearOfHighestRank("Mason", "M");
        System.out.println(year);
    }
    
    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double totalRank = 0;
        String yob = null;
        int year = 0;
        int count = 0;
        for (File f:dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fName = f.getName();
            yob = fName.substring(3,7);
            year = Integer.parseInt(yob);
            int currentRank = getRank2(year,name, gender,fr);
            if (currentRank != -1) {
                totalRank += currentRank;
                count += 1; 
            }
            System.out.println(totalRank);
            
        }
        
        if (totalRank == 0) {
            return -1.0;
        }
        double averageRank = totalRank/count;
        return averageRank;
    }
    
    public void testgetAverageRank() {
        double averageRank = getAverageRank("Jacob", "M");
        System.out.println(averageRank);
    
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int totalBirths = 0;
        int rank = getRank(year, name, gender);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
		rank--;
		if (rank > 0) {
		    totalBirths += Integer.parseInt(rec.get(2));
                }
            }
        }
        return totalBirths;
    }
    
    public void testgetTotalBirthsRankedHigher() {
        int totalBirth = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        System.out.println(totalBirth);
    }
}



