
public class Part3 {  
    public boolean twoOccurrences(String  stringa, String stringb){

        int count = ( stringb.split(stringa, -1).length ) - 1;
 
        if (count >= 2){
            return true;
        }
        return false;
    }
    
    public void testing(){
        boolean result = twoOccurrences("by", "A story by Abby Long");      
        System.out.println("string 'by' occurs 2 or more times in 'A story by Abby Long' ? " + result);
        
        result = twoOccurrences("by", "A story Abby Long");
        System.out.println("string 'by' occurs 2 or more times in 'A story by Abby Long' ? " + result);
        
        String res = lastPart("an", "banana");
        System.out.println("stringa: an");
        System.out.println("stringb: banana");
        System.out.println("result: " + res);
        
        res = lastPart("zoo", "forest");
        System.out.println("stringa: zoo");
        System.out.println("stringb: forest");
        System.out.println("result: " + res);
        
    }
    
    public String lastPart(String  stringa, String stringb){
        String result = "";
        
        result = stringb.indexOf(stringa) == -1 ? stringb : stringb.substring((stringb.indexOf(stringa) + stringa.length()));
        
        return result;
    }
    
    public static void main(String args[]){   
    }
}
