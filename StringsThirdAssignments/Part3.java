
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;

public class Part3 {
    // public StorageResource srIsFile(){
        // FileResource fr = new FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/dna/brca1line.fa");
        // String Newdna = fr.asString();
        // StorageResource sr = new StorageResource();
        // sr.add(Newdna);
        // for(String s : sr.data()){
            // System.out.println("this is my list of genes: " + s);
        // }
        // return sr;
    // }
    public float cgRatio(String dna) {
        int cgCount = 0;
        
        for(int i = 0; i < dna.length(); i++) {
            if( (dna.charAt(i) == 'C') || (dna.charAt(i) == 'G')){
                cgCount += 1;
            }
        }
        return (cgCount / (float)dna.length());
    }
    
    public void processGenes(StorageResource sr) {
        
        System.out.println("List of gene length greater than 9: ");
        for (String gene: sr.data()) {
            if (gene.length() > 9) {
            System.out.println(gene);
            }
        }
        
        System.out.println("----------------------------------------------------");
        
        int srCount = 0;
        for (String gene: sr.data()) {
            if (gene.length() > 9) {
              srCount += 1;
            }
        }
        System.out.println("Number of gene length greater than 9: " + srCount);
        
        System.out.println("----------------------------------------------------");
        
        System.out.println("List of gene cgRatio greater than 0.35: ");
        for (String gene: sr.data()) {
            if (cgRatio(gene) > 0.35) {
            System.out.println(gene);
            }
        }
        System.out.println("----------------------------------------------------");
        
        int srcgRatioCount = 0;
        for (String gene: sr.data()) {
            if (cgRatio(gene) > 0.35) {
              srcgRatioCount += 1;
            }
        }
        System.out.println("Number of gene cgRatio greater than 0.35: " + srcgRatioCount);
        
        System.out.println("----------------------------------------------------");
        
        int longestGene = 0;
        for (String gene: sr.data()) {
            if (gene.length() > longestGene) {
               longestGene = gene.length();
            }
        }
        System.out.println("Length of the longest gene is: " + longestGene);
        
        System.out.println("----------------------------------------------------");
    }
    
    public void testProcessGenes() {
        StorageResource sr = new StorageResource();
        
        sr.add("ATGGATATATATAA");
        sr.add("AGTTAGGAAATAG");
        sr.add("ATGTAA");
        sr.add("ATGCCTGGATA");
        sr.add("CTGATGATATTAA");
        
        processGenes(sr);
        
        
    
    }
    
    
}
