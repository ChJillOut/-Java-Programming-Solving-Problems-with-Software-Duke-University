
/**
 * Write a description of Part1 here.
 * 
 * @author (Jill Liu) 
 * @version (01/15/2018)
 */
import edu.duke.*;
import java.io.File;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        startIndex = dna.indexOf("ATG",0);
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff%3 == 0) {
            return currIndex;
            }
            else {
            currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna, int startIndex) {
        startIndex = dna.indexOf("ATG");
        if (startIndex != -1) {
            int taaIndex = findStopCodon(dna, startIndex,"TAA");
            int tagIndex = findStopCodon(dna, startIndex,"TAG");
            int tgaIndex = findStopCodon(dna, startIndex,"TGA");
            int temp = Math.min(taaIndex,tagIndex);
            int min = Math.min(temp,tagIndex);
            if (min == dna.length()) {
                return "";
            }
            return dna.substring(startIndex, min+3);
        }
        return "";
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0; 
        while(true) {
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex+currentGene.length());
        }
        return geneList;
    }
}

