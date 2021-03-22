
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class Part2 {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord colhr = null;
        double temp = 100.0;
        
        for(CSVRecord record: parser) {
            if((Double.parseDouble(record.get("TemperatureF")) < temp) && (!record.get("TemperatureF").equals("-9999"))) {
                temp = Double.parseDouble(record.get("TemperatureF"));
                colhr = record;
        }
       }
       return colhr;
    }
    
     
    public void testColdestHourInFile() {
        FileResource fr =  new  FileResource("/home/girish/Documents/mahe/Coursera/Java Programming/nc_weather/2014/weather-2014-05-01.csv");
        CSVParser parser = fr.getCSVParser();
        
        CSVRecord colhr = coldestHourInFile(parser);
        System.out.println(colhr.get("TemperatureF") + ": " + colhr.get("DateUTC"));
    }

    public String fileWithColdestTemperature() {
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        double temp = 100.0;
        String fileName = "";
        
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            
            if (coldestSoFar == null) {
                coldestSoFar = current;
                fileName = f.toString();
            }
            else {
                    if((Double.parseDouble(current.get("TemperatureF")) < temp) && (!current.get("TemperatureF").equals("-9999"))) {
                      temp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                      coldestSoFar = current;
                      fileName = f.toString();
                  }
                }
        }
        return fileName;
    }
    
    public void testFileWithColdestTemperature() {
         String fileName = fileWithColdestTemperature();
         FileResource fr = new FileResource(fileName);
         CSVParser parser = fr.getCSVParser();
         CSVParser newparser = fr.getCSVParser();
         
         System.out.println("Coldest day was in file: " + fileName);
         System.out.println("Coldest temperature on that day was: " + coldestHourInFile(parser).get("TemperatureF"));
         System.out.println("All the Temperatures on the coldest day were: ");
         
        for(CSVRecord record: newparser) {
             //System.out.println(record);
             System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
        }   
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        double lowestHumidity = 0.0;
        CSVRecord lowestHumidityRecord = null;
        
        for(CSVRecord record: parser) {
            if(!record.get("Humidity").equals("N/A")){
                if (lowestHumidity == 0.0) {
                    lowestHumidityRecord = record;
                    lowestHumidity = Double.parseDouble(record.get("Humidity"));
                } else {
                    if ((Double.parseDouble(record.get("Humidity"))) < lowestHumidity) {
                         lowestHumidityRecord = record;
                         lowestHumidity = Double.parseDouble(record.get("Humidity"));
                    }
                }
            }
        }
        return lowestHumidityRecord;
    }
    
    public void testLowestHumidityInFile() {
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser();
            CSVRecord csv = lowestHumidityInFile(parser);
            
            System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        }
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestHumiditySoFar = null;
        DirectoryResource dr = new DirectoryResource();
        double humid = 100.0;
        String fileName = "";
        
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            
            if (lowestHumiditySoFar == null) {
                lowestHumiditySoFar = current;
                fileName = f.toString();
            }
            else {
                  if(!current.get("Humidity").equals("N/A")){
                    if((Double.parseDouble(current.get("Humidity")) < humid)) {
                      humid = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
                      lowestHumiditySoFar = current;
                      fileName = f.toString();
                    }
                  }
                }
        }
        return lowestHumiditySoFar;
    }
    
    public void testLowestHumidityInManyFiles() {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        double length = 0.0;
        double sumT = 0.0;
        
        for(CSVRecord record: parser) {
            length += 1;
            sumT += (Double.parseDouble(record.get("TemperatureF")));
        }
        
        return (sumT / length);
    }
    
    public void testAverageTemperatureInFile() {
        DirectoryResource dr = new DirectoryResource();
        double avgTemp = 0.0;
        
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            avgTemp = averageTemperatureInFile(fr.getCSVParser());
        
        }
        
        System.out.println("Average temperature in file is " + avgTemp);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, double value) {
        double length = 0.0;
        double sumT = 0.0;
        
        for(CSVRecord record: parser) {
            if (Double.parseDouble(record.get("Humidity")) > value) {
                length += 1;
                sumT += (Double.parseDouble(record.get("TemperatureF")));
           }
        }
        
        return (sumT == 0.0 ? 0.0 : (sumT / length));
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        DirectoryResource dr = new DirectoryResource();
        double avgTemp = 0.0;
        
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            avgTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80.0);
        
        }
        
        if (avgTemp == 0.0) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average temperature in file is " + avgTemp);
        }
    }
    
}
