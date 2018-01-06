
/**
 * This program will determine if a DNA strand has a gene in it given any specific start codon and stop codon.  
 * 
 * @author (Jill Liu) 
 * @version (01/05/2018)
 */
public class Part2 {
    public String findSimpleGene (String dna,String startCodon,String stopCodon) {
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
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
        String dna;
        String gene;
        String startCodon = "ATG";
        String stopCodon = "TAA";
       
        dna = "cctatgtgagccgtataa";
        System.out.println(dna);
        if (dna != dna.toUpperCase()){
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println(gene);
        
        dna = "CCATGAAGCCG";
        System.out.println(dna);
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println(gene);
        
        dna = "CCTATTAAGCCG";
        System.out.println(dna);
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println(gene);
        
        dna = "CCTATGTGAGCCGTATAA";
        System.out.println(dna);
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println(gene);
        
        dna = "cctatgtgagccgtataa";
        System.out.println(dna);
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println(gene);
        
        dna = "CCTATGTGAGCCGTACGTAA";
        System.out.println(dna);
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println(gene);
    }
}
