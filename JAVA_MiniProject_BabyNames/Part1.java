
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part1 {
    public void printNames () {
		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int totalGirlNames = 0;
		int totalBoyNames = 0;
		int totalNames = 0;
		
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			totalNames += 1;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				totalBoyNames += 1;
			}
			else {
				totalGirls += numBorn;
				totalGirlNames += 1;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
		
		System.out.println("total names = " + totalNames);
		System.out.println("total female names = " + totalGirlNames);
		System.out.println("total male names = " + totalBoyNames);
	}

	public void testTotalBirths () {
		FileResource fr = new FileResource();
		//FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
	}
	
	public int getRank(int year, String name, String gender) {
	    int rank = 0;
	    
	    FileResource fr = new FileResource();
	    
	    for (CSVRecord rec : fr.getCSVParser(false)) {
	        if (rec.get(1).equals(gender) ){
	            rank += 1;
	            if (rec.get(0).equals(name)) {
	                return rank;
	            }
	    }
	   }
	    
	    return -1;
	}

	public void testGetRank() {
	    int rank = getRank(2012, "Mason", "M");
	    
	    if (rank == -1) {
	        System.out.println("Rank does not exist in the file for the gender given ");
	    } else {
	        System.out.println("Rank for the given gender and name in the file : " + rank);
	    }
	    
	}
	
	public String getName(int year, int rank, String gender) {
	    int ranking = 0;
	    
	    FileResource fr = new FileResource();
	    
	    for (CSVRecord rec : fr.getCSVParser(false)) {
	        if (rec.get(1).equals(gender) ){
	            ranking += 1;
	            if (ranking == rank) {
	                return rec.get(0);
	            }
	    }
	   }
	   return "NO NAME";
	}
	
	public void whatIsNameInYear(String name , int year, int newYear, String gender) {
	    int rank = getRank(year, name, gender);
	    String newname = getName(newYear, rank, gender);
	    
	    System.out.println(name + " born in " + year + " would be " + newname + " if she was born in " + newYear + ".");
	}
	
	public int yearOfHighestRank(String name, String gender) {
	    DirectoryResource dr = new DirectoryResource();
	    int highestRank = 0;
	    String year = "";
	    
	   for (File f: dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             CSVParser parser = fr.getCSVParser();
            
            int currentRank = 0;
            for (CSVRecord rec : fr.getCSVParser(false)) {
	        if (rec.get(1).equals(gender) ){
	            currentRank += 1;
	            if (rec.get(0).equals(name)) {
	                break;
	            }
	    }
          }
            if (highestRank == 0) {
                highestRank = currentRank;
                year = f.toString();
            } else {
                if (highestRank < currentRank) {
                    highestRank = currentRank;  
                    year = f.toString();
                }
            }

	}
	System.out.println(year);
	return highestRank;
     }
     
     public int getRankNew(CSVParser parser, String name, String gender) {
	    int rank = 0;
	    
	    //FileResource fr = new FileResource();
	    
	    for (CSVRecord rec : parser) {
	        if (rec.get(1).equals(gender) ){
	            rank += 1;
	            if (rec.get(0).equals(name)) {
	                return rank;
	            }
	    }
	   }
	    
	    return -1;
	}

     
     public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int numFiles = 0;
        int sumRank = 0;
        
        for (File f: dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             CSVParser parser = fr.getCSVParser(false);
             
             int rank = getRankNew(parser, name, gender);
             numFiles += 1;
             if (rank == -1){
                 rank = 0;
             }
             sumRank += rank;
                
       }
       
       return ((double)sumRank / (double)numFiles);
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int sum = 0;
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             CSVParser parser = fr.getCSVParser(false);
        
             for (CSVRecord rec: parser) {
                 
                 if (rec.get(1).equals(gender)) {
                     if (rec.get(0).equals(name)) {
                        break;
                     }
                     sum += (Integer.parseInt(rec.get(2)));
                     
                 }
             }
         }
    
        return sum;
     }
    
}
