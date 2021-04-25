import java.io.File;
import java.util.*;

public class filenamematching {

	public static void main(String[] args) {
		
		File input_file=new File("E:\\");
		String directory= input_file.getAbsolutePath();
		Scanner sc=new Scanner(System.in);
		String keyname;
		List<File> searchresults=new ArrayList<File>();
		System.out.println("Enter the name of file to search");
		keyname=sc.nextLine();
		System.out.println("key= "+keyname);
			searchresults=searchforkeyname(input_file,keyname);
		for(File f:searchresults)
			System.out.println(f);
		if(searchresults.isEmpty())
			System.out.println("File not found");

	}
	static List<File> searchforkeyname(File file,String keyname)
	{
		List<File> searchresults=new ArrayList<File>();
		String[] filesindirectory;     
		filesindirectory=file.list();       for(String s:filesindirectory) System.out.println(file+"   "+s);
		for(String s:filesindirectory)
		{
			System.out.println(s);
			if(s.matches(keyname+"[.][0-9|a-z|A-Z]*")||s.matches(keyname))
			{
				File f=new File(file.getAbsolutePath()+"\\"+s);
				searchresults.add(f);
			}
		}
		return(searchresults);
		
	}

}
