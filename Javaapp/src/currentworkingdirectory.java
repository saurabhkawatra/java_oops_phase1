import java.io.File;
import java.nio.file.Path;
public class currentworkingdirectory {

	public static void main(String[] args)
	{
		String workingdirectory,w2;
		workingdirectory=System.getProperty("workingdirectory");
		System.out.println(workingdirectory);
		File f1=new File("currentworkingdirectory.class");
		w2=f1.getParent();
		System.out.println(w2);
		w2=f1.getAbsolutePath();
		System.out.println(w2);
		Path p1;
		w2=f1.getPath();
		System.out.println(w2);
	}
}
