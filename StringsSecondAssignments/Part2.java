
/**
 * Write a description of Part2 here.
 * 
 * @author (Jill Liu) 
 * @version (1/9/2018)
 */
public class Part2 {
    public int howMany(String stringa,String stringb) {
        int currIndex = stringb.indexOf(stringa);
        int stringaLen = stringa.length();
        int count = 0;
        while (currIndex != -1) {
            currIndex = stringb.indexOf(stringa,currIndex + stringaLen);
            count = count + 1;
        }
        return count;
    }
    
    public void testHowMany() {
        String stringa = "s";
        String stringb = "this is an apple";
        int count = howMany(stringa,stringb);
        System.out.println(count);
        
        stringa = "an";
        stringb = "banana";
        count = howMany(stringa,stringb);
        System.out.println(count);
        
        stringa = "g";
        stringb = "banana";
        count = howMany(stringa,stringb);
        System.out.println(count);
        
        stringa = "GG";
        stringb = "ATGGGGA";
        count = howMany(stringa,stringb);
        System.out.println(count);
        
        
    }

}
