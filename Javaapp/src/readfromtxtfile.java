import java.io.*;
import java.time.LocalTime;
import java.net.*;
import java.util.*;
public class readfromtxtfile {

	public static void main(String[] args) {
		try
		{
		URL f=new URL("https://github.com/saurabhkawatra/java_oops_phase1/raw/master/Java.txt");
		BufferedReader bfr=new BufferedReader(new InputStreamReader(f.openStream()));
	     String i,j;
	     String k="this is text file\r\n"
	     		+ "these are new changes\r\n"
	     		+ "these are new changes 2";
	     String[] word;
	     int numwords=0;
	     j=bfr.readLine();
	     System.out.println(j); bfr.close();
	     
	     bfr=new BufferedReader(new InputStreamReader(f.openStream()));
	     while ((i = bfr.readLine()) != null)
	           System.out.println(i);
	     bfr.close();
	     
	     j="";
	     bfr=new BufferedReader(new InputStreamReader(f.openStream()));
	     while ((i = bfr.readLine()) != null)
	     j=j.concat(i+"\n");
	     System.out.println(j);
	     bfr.close();
	     
	     
	     if(k.matches("(.)*"))
	    	numwords++;
	     System.out.println(numwords);
	     
	     word=j.split("\\s");//splits the strings based on whitespace
         System.out.println("using split All words in your sentence are:");
         for(String x:word)
       	  System.out.println(x);
         
		System.out.println(word);
		System.out.println(j);
		}
		catch(Exception e)
		{System.out.println(e);}
		
		LocalTime lt= LocalTime.now();
		System.out.println(lt);
		
	}

}
