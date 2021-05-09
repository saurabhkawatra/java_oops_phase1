package projectpractise;
import java.io.*;
import java.util.Arrays;

class sorting
{
	static double getFolderSize(File dir)
	{
		File[] files=dir.listFiles();
		double size=0;
		if(files==null)
			return dir.length();
		for(File e:files)
		{
			if(e.isDirectory())
				size=size+getFolderSize(e);
			else
				size=size+e.length();
		}
		return(size);
	}

		public static void main(String[] args)
		{
			File file=new File("C:\\Users\\saura\\Desktop\\New folder (2)");
		
			File[] fa = file.listFiles();
			if(fa!=null)
			{
			String[] fname=new String[fa.length]; 
				
			for(int i=0;i<fa.length;i++)
			{
				String tempname=fa[i].getName();
				tempname=tempname.replace('(','\s');
				tempname=tempname.replace(')','\s');
				tempname=tempname.replace('.','\s');
				tempname=tempname.replace('-','\s');
				tempname=tempname.replaceAll("\\s","");
				//tempname=tempname.replaceAll("\\0","");
				tempname=tempname.replaceAll(" ","");
				fname[i]=tempname;
			}
			
			System.out.println("Files are being sorted");
			Arrays.sort(fname);
			for(String s:fname)
			System.out.println(s);

		    Arrays.sort(fa);
			System.out.println("\n\n**********************************************************************************************************************************");
			System.out.printf("%-4s %-70s %-40s %-50s","Sno.", "File name", "File Type", "File Size");
			System.out.println("\n\n**********************************************************************************************************************************");
		
		
			double size=0;
			int count=0;
			String unit="bytes";
			String fileType="file";
			for (File f : fa) 
			{	
				if (f.isDirectory()) 
				{
					size=getFolderSize(f);
					fileType="Directory";
				}
		
				else 
				{
					size=(double)f.length();
					String type = f.getName();
					String[] filesType=type.split("[.]");
					fileType= "."+filesType[filesType.length-1];
				}
				if (size<1024) 
				{
					size = (int) size/1;	
					unit="bytes";
				}
		
		
				else if (size>1024 && size<1024*1024) 
				{
					unit="KB";
					size=size/1024;
					size = Math.round(size*10.0)/10.0;	
				}
		
				else if (size>1024*1024 && size<1024*1024*1024) 
				{
					unit="MB";
					size=size/1024/1024;
					size = Math.round(size*100.0)/100.0;
				}
		
				else if (size>1024*1024*1024) 
				{
					unit="GB";
					size=size/1024/1024/1024;
					size = Math.round(size*100.0)/100.0;
		
				}
		
				System.out.printf("%-4s %-70s %-40s %-50s\n",++count, " "+f.getName(),fileType,size+" "+unit );
		
			}
		
		  }
			else
			{
				System.out.println("Given directory is an empty directory");
			}
		}
}