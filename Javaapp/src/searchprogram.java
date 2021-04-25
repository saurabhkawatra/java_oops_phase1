import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class searchprogram {

	public static void main(String[] args) {
		File input_file=new File("E:\\");
		String directory= input_file.getAbsolutePath();
		Scanner sc=new Scanner(System.in);
		String keyname,input;
		List<File> searchresults=new ArrayList<File>();
		System.out.println("Enter the name of file to search");
		input=sc.nextLine();
		keyname=Pattern.quote(input);
		System.out.println("key= "+keyname);
		String[] listoffiles=input_file.list();
		if(listoffiles.length==0)
		{
			System.out.println("Its an empty directory! No Files to search!");
		}
		else
		{
			File[] subdir=input_file.listFiles();
			for(File e:subdir)
				System.out.println(e);
			searchresults=searchfile(input_file,keyname);
			if(searchresults.isEmpty())
			{
				System.out.println("No results found!");
			}
			else
			{
				System.out.println("Search found results");
				for(File f:searchresults)
					System.out.println(f);
			}
			
		}
		

	}
	static List<File> searchfile(File input_file,String keyname)
	{
		List<File> searchresults=new ArrayList();
		File[] filesindirectory=new File[500];
		filesindirectory=input_file.listFiles();           //saving all the files in the input_file directory in filesindirectory 
		int numofsubdirectories=0,c=0;
		           
		
		       if(filesindirectory!=null)
		       {
		    	   for(File e:filesindirectory)                    //finding number of sub-folders in the directory
						if(e.isDirectory())
						{
							numofsubdirectories++;
						}
						
					
					File[] subdirectoryfiles = new File[numofsubdirectories];
					for(File e:filesindirectory)                    //Saving the sub-folders in subdirectoryfiles file array
						if(e.isDirectory())
							subdirectoryfiles[c++]=e;
					
					if(numofsubdirectories==0)
					{
						searchresults=searchforkeyname(input_file,keyname);
						return(searchresults);
					}
					else
					{
						searchresults=searchforkeyname(input_file,keyname);
						for(int i=0;i<numofsubdirectories;i++)
						{
							List<File> temp=null;
							   temp=searchfile(subdirectoryfiles[i],keyname);
							   if(temp==null)
							   {
								   continue;
							   }
							   else
							   {
								   for(File e:temp)
								    searchresults.add(e);
							   }
							   
						}
						return(searchresults);
				     }
		       }
		       else
		    	   return(null);
			
		
	}
	static List<File> searchforkeyname(File file,String keyname)
	{
		List<File> searchresults=new ArrayList<File>();
		String[] filesindirectory;
		filesindirectory=file.list();
		for(String s:filesindirectory)
		{
			if(s.matches(keyname+"[.][0-9|a-z|A-Z]*")||s.matches(keyname))
			{
				File f=new File(file.getAbsolutePath()+"\\"+s);
				searchresults.add(f);
			}
		}
		return(searchresults);
	}

}
