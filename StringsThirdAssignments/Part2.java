
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public float cgRatio(String dna) {
        int cgCount = 0;
        
        for(int i = 0; i < dna.length(); i++) {
            if( (dna.charAt(i) == 'C') || (dna.charAt(i) == 'G')){
                cgCount += 1;
            }
        }
        return (cgCount / (float)dna.length());
    }
    
    public void testcgRatio() {
        String dna = "ATGCCATAG";
        
        System.out.println("the cgRatio is: " + cgRatio(dna));
    }
    
    public int countCTG(String dna) {
        int count = 0;
        int startIndex = dna.indexOf("CTG");
        
        while(true) {
            if(startIndex != -1){
                count += 1;
                startIndex = dna.indexOf("CTG", startIndex + 3);
            } else {
                break;
            }
        }
        return count;
    }
    
    public void testCountCTC() {
        String dna = "ATGCTGAACTGAGAGCTGCTG";
        System.out.println("the number of CTG condons in the dna string: " + countCTG(dna));
    }
}
