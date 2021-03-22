//import edu.duke.*;

public class Part2 {
   public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = "";
        
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return result;
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1){
            return result;
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
        }
        
        if (startCodon == "ATG"){
           return result.toUpperCase();
        }
        return result.toLowerCase();
   }
    
   public void testSimpleGene(){
       String dna = "";
       
       dna = "DATAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna, "ATG", "TAA"));
       
       dna = "DAATGAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna, "ATG", "TAA"));
                     
       dna = "DADAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna, "ATG", "TAA"));
              
       dna = "DATGATTCDATCATAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna, "ATG", "TAA"));
              
       dna = "DATGATTCDATATAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna, "ATG", "TAA"));  
       
       dna = "datgattcdatcataa";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna, "atg", "taa"));
   }
   
   public static void main(String args[]){
   }
       
}
