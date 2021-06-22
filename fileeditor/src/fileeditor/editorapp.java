package fileeditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

public class editorapp {

	public static void main(String[] args) {
		
		
		File file = new File("C:\\Users\\saura\\Downloads\\source (1).txt");
		String tempfile="";
		FileReader infr=null;
		
		try {
			infr=new FileReader(file);
			BufferedReader br=new BufferedReader(infr);
			int x=0;
			
				String firstline=br.readLine();
				String secondline=br.readLine();
				while(true)
				{
					String sx=br.readLine();
					if(sx==null)
						break;
					else
						if(x==0)
						{
							x++;tempfile=tempfile.concat(sx);
						}
						else
						{
							tempfile=tempfile.concat("\n"+sx);
						}
					
				}
													System.out.println(tempfile);
				file.delete();
				file.createNewFile();
				FileWriter fwr;
				fwr=new FileWriter(file);
				BufferedWriter bwr=new BufferedWriter(fwr);
				
					bwr.write(tempfile);
					bwr.flush();
				
				
			
		}catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
