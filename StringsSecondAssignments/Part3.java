
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    public int countGenes(String dna) {
        int countDNAStrings = 0;

        while (true) {
            if(findGene(dna) == "") {
                break;
            } else {
            countDNAStrings += 1;
            dna = (dna.substring((dna.indexOf(findGene(dna)) + findGene(dna).length()), dna.length()));
        }
            
        }
        return countDNAStrings;
    }
    
    public void testCountGenes() {
        String dna= "AAATGGTAGAGAGATAAAATAGGATGTAAATGTAGTGA";
        
        System.out.println("the number of genes in the given dna: " + countGenes(dna));
    }
}


