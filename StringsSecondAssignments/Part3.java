
/**
 * Write a description of Part3 here.
 * 
 * @author (Jill Liu) 
 * @version (1/9/2018)
 */
public class Part3 {
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
    
    public String findGene(String dna) {
    int startIndex = dna.indexOf("ATG");
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
    
    public int countGenes(String dna) {
        int count = 0;
        while (findGene(dna) != "") {
            String gene = findGene(dna);
            int geneLen = gene.length();
            int geneIndex = dna.indexOf(gene);
            dna = dna.substring(geneIndex+geneLen);
            count = count + 1;
        }
        return count;
    }
    
    public void testCountGenes() {
        String dna = "CCATGTAAAAGCTATGTACGGCTAGTGA";
        int count = countGenes(dna);
        System.out.println(count);
    }
}
  
