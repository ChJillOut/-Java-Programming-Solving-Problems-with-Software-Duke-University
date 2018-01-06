
/**
 * A program that reads the lines from the file at http://www.dukelearntoprogram.com/course2/data/manylinks.html, and prints each URL on the page that is a link to youtube.com. 
 * 
 * @author (Jill Liu) 
 * @version (01/05/2018)
 */
import edu.duke.*;
public class Part4 {
    public String FindWebLinks(String keyword,String line){
        int keywordLength = keyword.length();
        int keywordIndex;
        String lineLower = line.toLowerCase();
        keywordIndex = lineLower.indexOf(keyword);
        if (keywordIndex != -1) {
            int startIndex = lineLower.lastIndexOf("\"", keywordIndex-1);
            int endIndex = lineLower.indexOf("\"",keywordIndex+keywordLength);
            String link = line.substring(startIndex+1,endIndex);
            return link;
        }
        return "not a youtube link";
    }
    
    public void testURL() {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String line : ur.lines()) {
            String result = FindWebLinks("youtube.com", line);
            System.out.println(result);
        }
    }
}

  
