import java.io.*;
import java.time.LocalTime;
import java.net.*;
import java.util.*;

public class checktest {
	
	public static void main(String[] args) {
		try
		{
			File fa=new File("C:\\Users\\saura\\Desktop\\experiment.txt");
		URL file=new URL("https://github.com/saurabhkawatra/java_oops_phase1/raw/master/Java.txt");
		BufferedReader buff=new BufferedReader(new InputStreamReader(file.openStream()));
		BufferedReader lobuff=new BufferedReader(new FileReader(fa));
		int x=1,y=0;
	     String i,j="";
	     char c='a';
	     String k="this is text file\r\n"
	     		+ "these are new changes\r\n"
	     		+ "these are new changes 2";
	     System.out.println("program begins");
	    	 
	     while(y != -1)
	     {
	    	 y=buff.read();
	    	 c=(char)(y);
	    	 if(c =='\s'|c=='\n'|c=='\r'|y==-1|c=='.'|c==','|c==':'|c==';'|c=='"')
	    	 {
	    		 if(j!="")
	    		 {
	    		 System.out.println("No "+x+" word in file: "+j);
	    		 x++;
	    		 }
	    		 j="";
	    	 }
	    	 else
	    	 j = j.concat(Character.toString(c));
	    	 
	     }
	     lobuff.close();
	     buff.close();
	    	 
	     if(k.matches("[(.)*|(\n)*|(\r)*]*"))
	     {
	    	 x++;
	    System.out.println("pattern match"+x);	 
	     }
	     
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}

}
	
}