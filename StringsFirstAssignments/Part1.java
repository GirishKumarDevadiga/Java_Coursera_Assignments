//import edu.duke.*;

public class Part1 {
   public String findSimpleGene(String dna) {
        String result = "";
        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return result;
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            return result;
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
        }
        
        return result;
   }
    
   public void testSimpleGene(){
       String dna = "";
       
       dna = "DATAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna));
       
       dna = "DAATGAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna));
                     
       dna = "DADAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna));
              
       dna = "DATGATTCDATCATAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna));
              
       dna = "DATGATTCDATATAA";
       System.out.println("The string is " + dna);
       System.out.println("The gene is " + findSimpleGene(dna));  
   }
   
   public static void main(String args[]){
   }
       
}
