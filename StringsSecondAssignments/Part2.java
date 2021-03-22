
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int stringaCount = 0;
        int startIndex = stringb.indexOf(stringa);
        
        while(true) {
            if ( startIndex + stringa.length() <= stringb.length()) { 
            //System.out.println(stringb.substring(startIndex, (startIndex + stringa.length())));
            if(stringb.substring(startIndex, (startIndex + stringa.length())).equals(stringa)) {
                stringaCount += 1;
                startIndex = startIndex + stringa.length();
            } else {
            startIndex = startIndex + 1;
        }
        } else {
            break;
        }
        
        }
        
        return stringaCount;
    }
    
    public void testHowMany() {
        String stringa = "AA";
        String stringb = "ATAAAA";
        
        System.out.println("number of stringa appears in stringb: " + howMany(stringa, stringb));
        
        stringa = "GAA";
        stringb = "ATGAACGAATTGAATC";
        
        System.out.println("number of stringa appears in stringb: " + howMany(stringa, stringb));
        
        stringa = "11";
        stringb = "1111111";
        
        System.out.println("number of stringa appears in stringb: " + howMany(stringa, stringb));
    }

}
