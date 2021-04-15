import java.util.*;


public class stringarraypractise {

	public static void main(String[] args) {
		String s=new String();
		Scanner sc=new Scanner(System.in);
          System.out.println("Enter the string");
          s=sc.nextLine();
          System.out.println(s);
          s=s.concat(" yay");
          System.out.println("After concat string= "+s);
          
          System.out.println("Enter the string");
          s=sc.nextLine();
          
          String[] words=s.split("\\s");//splits the strings based on whitespace
          System.out.println("using split All words in your sentence are:");
          for(String i:words)
        	  System.out.println(i);
          
          System.out.println("Enter the date string that will be split after '/' keyword");
          s=sc.nextLine();
          
          if(s.matches("(\\d)?[\\d]/(\\d)?[\\d]/[\\d][\\d](\\d)?(\\d)?"))
          System.out.println("correct date format");
          else
        	  System.out.println("incorrect date format");
          
          words=s.split("/");
          System.out.println("words=s.split"+"\nDate= "+words[0]+" Month= "+words[1]+" Year= "+words[2]);
         
          System.out.println("Enter the date string again");
          s=sc.nextLine();
          
          if(s.matches("(([0|1|2]?[1-9])|([3][0|1]))/(([0]?[1-9])|([1][0|1|2]))/[\\d][\\d][\\d]?[\\d]?"))
        	  System.out.println("Correct format");
          else
        	  System.out.println("Invalid format");
	}

}
