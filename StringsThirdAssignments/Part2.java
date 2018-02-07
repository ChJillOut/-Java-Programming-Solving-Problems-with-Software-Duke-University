
/**
 * Write a description of Part2 here.
 * 
 * @author (Jill Liu) 
 * @version ()
 */
public class Part2 {
    public float cgRatio(String dna) {
        int startCIndex = 0;
        int startGIndex = 0;
        int Ccount = 0;
        int Gcount = 0;
        while (startCIndex != -1) {
        Ccount = Ccount + 1;
        startCIndex = dna.indexOf("C",startCIndex);
        }
        
        while (startGIndex != -1) {
        Gcount = Gcount + 1;
        startGIndex = dna.indexOf("G",startGIndex);
        }
        
        float ratio = (float)(Gcount+Ccount)/(float)dna.length();
        return ratio;
    }

}
