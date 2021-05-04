import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortname implements Comparable<File> {
	List<File> sn;
	
	public int compareTo(File f)
	{
		String name1=f1.getName();
		
		for(int i=0;i<name1.length();i++)
		{
			if(name1.charAt(i)==name2.charAt(i))
			{
				//int ascii=name1.charAt(i);
				//if(48<=ascii&&ascii<=57)
				//{
					
				//}
				//else
				return(0);
			}
				
			else if(name1.charAt(i)>(name2.charAt(i)))
				return(-1);
			else
				return(1);
		}
		
	
		
	}
	
	public static void main(String[] args) {
		File file= new File("C:\\Users\\saura\\Downloads\\Screenshots\\Screenshots");
		sortname s1=new sortname();
		File[] fa=file.listFiles();
		for(File e:fa)
		{
			s1.sn.add(e);
		}
		Collections.sort(s1.sn);
		for(File e:s1.sn)
		{
			System.out.println(e);
		}
													
	
	}
}

											