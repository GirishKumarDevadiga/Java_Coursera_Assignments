/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;

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
    
    public StorageResource getAllGenes(String dna) {
        //String dna= "AAATGGTAGAGAGATAAAATAGGATGTAAATGTAGTGA"; 
        StorageResource genes = new StorageResource();

        while (true) {
            if(findGene(dna) == "") {
                break;
            } else {
            genes.add(findGene(dna));
            dna = (dna.substring((dna.indexOf(findGene(dna)) + findGene(dna).length()), dna.length()));
        }
            
        }
      return genes;
    }
    
     public float cgRatio(String dna) {
        int cgCount = 0;
        
        for(int i = 0; i < dna.length(); i++) {
            if( (dna.charAt(i) == 'C') || (dna.charAt(i) == 'G')){
                cgCount += 1;
            }
        }
        return (cgCount / (float)dna.length());
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
    
    public void testGetAllGenes() {
        //String dna= "AAATGGTAGAGAGATAAAATAGGATGTAAATGTAGTGA"; 
        //StorageResource genes = getAllGenes(dna);
        
        FileResource fr = new FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/dna/GRch38dnapart.fa");
        String dna = fr.asString();
        //System.out.println(dna.length());
        StorageResource genes = getAllGenes(dna.toUpperCase());
        //System.out.println(countCTG(dna.toUpperCase()));
        // int count = 0;
         // for (String gene : genes.data()){
            // // System.out.println("genes are: "+ gene);
            // if (cgRatio(gene) > 0.35) {
            // count += 1;
        // }
        // }
        int longestGene = 0;
        for (String gene: genes.data()) {
            if (gene.length() > longestGene) {
               longestGene = gene.length();
            }
        }
        System.out.println("Length of the longest gene is: " + longestGene);
        // for (String gene : genes.data()){
            // if (gene.length() > 60) {
            // //System.out.println("genes are: "+ gene);
            // count += 1;
        // }
        // }
        //System.out.println(count);
    }
}
