	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;


public class Sona_Markosyan {
	
	  public static void main(String [] args) throws IOException {
		  System.out.println("Geben Sie den Pfad zu dem File");
		  Scanner in = new Scanner(System.in);
	   String pfad = in.nextLine();
	 //  String pfad = "C:\\Users\\marko\\OneDrive\\Desktop\\Studierendendaten.txt";
	    FileReader fileReader = new FileReader(pfad);

	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      int counter = 0;
	      while((line = bufferedReader.readLine()) != null) {
	    	  if(!match(line)) {
	    		  counter++;
	    		  System.out.println(counter+" "+line);  
	    	  }
	      }
	    }
	  }
	  
	  public static boolean match(String str) {
		  //Abschluss +5
		  Pattern p = Pattern.compile("^(Master|Bachelor)\\t");
		  Matcher m = p.matcher(str);
		  
		  
		  //FD-Nummer +14
		  Pattern p2 = Pattern.compile("\\t(fd(ai|ei|lt|pg|wi)[0-9]{4}\\t)");
		  Matcher m2 = p2.matcher(str);
		  
		  //Name +13
		  Pattern p3 = Pattern.compile("\\t\\b([A-Z]{1}[a-z]+((\\s|\\-){1}[A-z]{1}[a-z]*)*)( )([A-Z]{1}[a-z]+(( |\\-){1}[A-z]{1}[a-z]*)*)\\b\\t");
		  Matcher m3 = p3.matcher(str);
		  
		  //Geburtsdatum +17
		  Pattern p4 = Pattern.compile("\\t(([0-2][0-9]|31|30)\\.([0][1-9]|10|11|12)\\.[0-9]{4}\\t)");
		  Matcher m4 = p4.matcher(str);
		  
		  //Telefon-Nr. +16
		  Pattern p5 = Pattern.compile("\\t((0[0-9]+ )([0-9]*)(-[0-9]*)?)|((\\+[1-9][0-9]?\\s[0-9]*)( [0-9]*)(-[0-9]*)?)\\t");
		  Matcher m5 = p5.matcher(str);
		  
		//Email+19
		  Pattern p6 = Pattern.compile("\\t([a-zA-Z\\.,\\-_0-9]+)@[a-zA-Z0-9][a-zA-Z\\.\\\",\\-_0-9]+\\.[a-z]{2,3}\\t");
	   	  Matcher m6 = p6.matcher(str);
		  
	   	//Password+9
		  Pattern p7 = Pattern.compile("\\t((?=.*[a-z])(?=.*[0-9])(?=.*[!\"$%&/().\\-_?])(?=.*[A-Z]).{0,16})$");
	   	  Matcher m7 = p7.matcher(str);
		  
		   
		  boolean b = m4.find()&&m3.find();
		  return b; 
	  }
}
