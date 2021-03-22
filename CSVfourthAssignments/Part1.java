
import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

/**
 * Write a description of Part1 here.
 * @author (your name) @version (a version number or a date)
 */
public class Part1
{

    public void tetser()
    {
        FileResource fr =  new  FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        
        for(CSVRecord record: parser) {
            System.out.println(record.get("Country"));
        }
    }
    
    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record: parser) {
            if(record.get("Country").equals(country)) {
                return (record.get("Country") + ": " + record.get("Exports"));
            }
        }
        return "NOT FOUND";
    }
    
    public void testCountryInfo() {
        FileResource fr =  new  FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        
        System.out.println("Country exports details:- ");
        System.out.println(countryInfo(parser, "Nauru"));
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record: parser) {
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public void testlistExportersTwoProducts() {
        FileResource fr =  new  FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        System.out.println("Country details:- ");
        listExportersTwoProducts(parser, "cotton", "flowers");
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for(CSVRecord record:parser) {
            if (record.get("Exports").contains(exportItem)) {
                count += 1;
            }
        }
        return count;
    }
    
    public void testNumberOfExporters() {
        FileResource fr =  new  FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        
        System.out.println("Number of countries that exports: ");
        System.out.println(numberOfExporters(parser, "cocoa"));
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record:parser) {
            if (record.get("Value (dollars)").length() > amount.length()) {
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }
    
    public void testBigExporters() {
        FileResource fr =  new  FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        
        bigExporters(parser, "$999,999,999,999");
    }
}
