
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCondon(String dna, int startIndex, String stopCondon) {
        startIndex = dna.indexOf("ATG");
        int currentIndex = dna.indexOf(stopCondon, startIndex + 3);
        
        while (currentIndex != -1) {
            if ((currentIndex - startIndex) % 3 == 0) {
               return currentIndex;  
            }
            else {
               currentIndex = dna.indexOf(stopCondon, currentIndex + 1); 
            }
        }
      
        return dna.length();
    }
    
    public void testFindStopCodon() {
        String dna = "AAATGGTAGAGAGATAAAATAGGATGA";
        System.out.println("The data string is :" + dna);
        int stopCondon = findStopCondon(dna, 0, "TAA");
        System.out.println("The stop condon found at index :" + Integer.toString(stopCondon));
        
        dna = "AAATGGTA";
        System.out.println("The data string is :" + dna);
        stopCondon = findStopCondon(dna, 0, "TAA");
        System.out.println("The stop condon found at index :" + Integer.toString(stopCondon));
        
    }

    
    public String findGene(String dna) {
        int startCondonIndex = dna.indexOf("ATG");
        
        if (startCondonIndex == -1) {
            return "";
        }
        
        int taaCondon = findStopCondon(dna, startCondonIndex, "TAA");
        int tagCondon = findStopCondon(dna, startCondonIndex, "TAG");
        int tgaCondon = findStopCondon(dna, startCondonIndex, "TGA");
        
        int minCondonIndex = Math.min(Math.min(taaCondon, tagCondon), tgaCondon);
        
        return minCondonIndex == dna.length() ? "": dna.substring(startCondonIndex, minCondonIndex + 3);
        
    }
    
    public void testFindGene(){
        String dna= "AAATGGTAGAGAGATAAAATAGGATGA";
        System.out.println("The dna string is :" + dna);
        String gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "AAATGGTA";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
    }
    
    public void printAllGenes() {
        String dna= "AATGCTAACTAGCTGACTAAT"; //"AAATGGTAGAGAGATAAAATAGGATGTAAATGTAGTGA"; 

        while (true) {
            System.out.println("printing genes: " + findGene(dna));
            dna = (dna.substring((dna.indexOf(findGene(dna)) + findGene(dna).length()), dna.length()));
            if(findGene(dna) == "") {
                break;
            }
            
        }
    }
}
