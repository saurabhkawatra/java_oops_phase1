import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class filenamepatternmatching {

	public static void main(String[] args) {
	   File f=new File("C:\\Users\\saura\\Desktop\\New folder (2)");
	   
	   System.out.println();
	   Scanner sc=new Scanner(System.in);
	   String Input=sc.nextLine();
	   String key=Pattern.quote(Input);
	   String unquotekey=key.substring(2,key.length()-2);
	   System.out.println("key: "+key+" unkey: "+unquotekey);
	   String[] names=f.list();
	   
	   for(String e:names)
	   {
		   if(e.equalsIgnoreCase(unquotekey))
			   System.out.println("Match found "+e);
	   }

	}

}
