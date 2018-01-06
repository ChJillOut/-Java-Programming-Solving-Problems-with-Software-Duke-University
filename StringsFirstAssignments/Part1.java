
/**
 * This program will determine if a DNA strand has a gene in it with start codon "ATG"and stop codon "TAA".
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene (String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            return "";
        }
        String result = dna.substring(startIndex, stopIndex+3);
        if ((stopIndex-startIndex)%3 == 0){
            return result;
        }
        return "";
    }
    
    public void testSimpleGene() {
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(dna);
        String gene = findSimpleGene(dna);
        System.out.println(gene);
        
        dna = "CCATGAAGCCG";
        System.out.println(dna);
        gene = findSimpleGene(dna);
        System.out.println(gene);
        
        dna = "CCTATTAAGCCG";
        System.out.println(dna);
        gene = findSimpleGene(dna);
        System.out.println(gene);
        
        dna = "CCTATGTGAGCCGTATAA";
        System.out.println(dna);
        gene = findSimpleGene(dna);
        System.out.println(gene);
        
        dna = "CCTATGTGAGCCGTACGTAA";
        System.out.println(dna);
        gene = findSimpleGene(dna);
        System.out.println(gene);
    }
    
    
}
