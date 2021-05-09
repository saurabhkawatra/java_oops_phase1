import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortname implements Comparable<sortname> {
	File sn;
	
	public int compareTo(sortname o)
	{
		
		String name1=o.sn.getName();
		String name2=this.sn.getName();
		for(int i=0;i<name1.length();i++)
		{
			if(name1.charAt(i)==name2.charAt(i))
			{
				int ascii=name1.charAt(i);
				int ascii2=name2.charAt(i);
				if(48<=ascii&&ascii<=57)
				{
					
				}
				else
				return(0);
			}	
			else if(name1.charAt(i)>(name2.charAt(i)))
				return(1);
			else
				return(-1);
		}
		return(0);
	}
	
	
	sortname(File e)
	{
		this.sn=e;
	}
	
	public static void main(String[] args) {
		File file= new File("C:\\Users\\saura\\Downloads\\Screenshots\\Screenshots");
		List<File> fa=new ArrayList<>();
		List<sortname> sortnamelist=new ArrayList<>();
		for(File e:file.listFiles())
		{
			fa.add(e);
		}
		for(File e:fa)
		{
			sortnamelist.add(new sortname(e));
		}
		Collections.sort(sortnamelist);
		for(sortname e:sortnamelist)
		{
			System.out.println(e.sn.getName());
		}
													
	
	}
}

											