
/**
 * The twoOccurrences method returns true if stringa appears at least twice in stringb, otherwise it returns false. 
 * The lastPart method finds the first occurrence of stringa in stringb, and returns the part of stringb that follows stringa. If stringa does not occur in stringb, then return stringb.
 * 
 * @author (Jill Liu) 
 * @version (01/05/2018)
 */
public class Part3 {
    public Boolean twoOccurrences(String stringa, String stringb) {
        int stringaLength = stringa.length();
        int occurrenceIndex = stringb.indexOf(stringa);
        if (occurrenceIndex != -1) {
            if (stringb.indexOf(stringa,stringaLength+occurrenceIndex) != -1) {
            return true;
            }
        return false; 
        }
        return false;
    }
    
    public void testing() {
    String stringa = "s";
    String stringb = "professor";
    System.out.println(stringa+" "+stringb);
    Boolean result = twoOccurrences(stringa,stringb);
    System.out.println(result);
    
    stringa = "as";
    stringb = "This is a test program";
    System.out.println(stringa+" "+stringb);
    result = twoOccurrences(stringa,stringb);
    System.out.println(result);
    
    stringa = "an";
    stringb = "banana";
    System.out.println(stringa+" "+stringb);
    String result2 = lastPart(stringa,stringb);
    System.out.println(result2);
    
    stringa = "zoo";
    stringb = "forest";
    System.out.println(stringa+" "+stringb);
    result2 = lastPart(stringa,stringb);
    System.out.println(result2);
    }
    
    public String lastPart(String stringa, String stringb) {
        int stringaLength = stringa.length();
        int occurrenceIndex = stringb.indexOf(stringa);
        if (occurrenceIndex != -1) {
            return stringb.substring(stringaLength+occurrenceIndex);
        }
        return stringb;    
    }
}
