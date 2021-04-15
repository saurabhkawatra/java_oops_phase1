import java.awt.datatransfer.SystemFlavorMap;
import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class stringarraypractise {

	public static void main(String[] args) {
		String s=new String();
		Scanner sc=new Scanner(System.in);
          System.out.println("Enter the string");
          s=sc.nextLine();
          System.out.println(s);
          s=s.concat(" yay");
          System.out.println(s);
          
          System.out.println("Enter the string");
          s=sc.nextLine();
          
          String[] words=s.split("\\s");//splits the strings based on whitespace
          System.out.println("All words in your sentence are:");
          for(String i:words)
        	  System.out.println(i);
	}

}
