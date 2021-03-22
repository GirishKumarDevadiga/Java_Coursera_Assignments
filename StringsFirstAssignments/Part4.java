import edu.duke.*;

public class Part4 {  
    public void  StringsFirstAssignments(){
       URLResource file =  new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
   	for (String item : file.words()) {
       	   String itemLower = item.toLowerCase();
       	   int pos = itemLower.indexOf("youtube.com");
       	   if (pos != -1) {
           	int beg = itemLower.lastIndexOf("\"",pos);
int end = itemLower.indexOf("\"", pos+1);
System.out.println(itemLower.substring(beg+1,end));
               }
   	}
    }
    
    public static void main(String args[]){
    }
}
