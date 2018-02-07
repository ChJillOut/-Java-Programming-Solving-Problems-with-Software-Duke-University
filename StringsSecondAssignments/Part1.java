
/**
 * Write a description of Part1 here.
 * 
 * @author (Jill Liu) 
 * @version (01/07/2018)
 */
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
    
    public void testFindStopCodon() {
        String dna = "ATGAATTAA";
        int gene = findStopCodon(dna, 0, "TAA");
        if (gene == 6) {
            System.out.println("no error!");
        }
        else{
            System.out.println("error on 6!");
        }
        
        //     01234567890123456789 
        dna = "CCATGATTAAGCTATGCTAAGG";
        gene = findStopCodon(dna, 0, "TAA");
        if (gene == 17) {
            System.out.println("no error!");
        }
        else{
            System.out.println("error on 17!");
        }
        
    }
    
    public void testFindGene() {
        String dna;
        String gene;
        dna = "CCATTAAGCTATGCTAAGG";
        gene = findGene(dna);
        System.out.println(gene);
        
        dna = "CCATGATTAAGCTATGCTAAGG";
        gene = findGene(dna);
        System.out.println(gene);
        
        dna = "CCATGATTAAGCTATGCTAAGGCTAGTGA";
        gene = findGene(dna);
        System.out.println(gene);
        
        dna = "CCATGATTAAGCTATTAAGGCTAGTGA";
        gene = findGene(dna);
        System.out.println(gene);
        
        
    
    }
}
