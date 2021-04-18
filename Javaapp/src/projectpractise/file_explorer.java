package projectpractise;
import java.io.*;
import java.util.*;

class homescreen{
	int option;
	homescreen()
	{
		System.out.println("Select an Option");
		System.out.println("1. Create a new File");
		System.out.println("2. Delete an existing File in the Directory");
		System.out.println("3. Exit the application");
		Scanner sc=new Scanner(System.in);
		this.option=sc.nextInt();
	}
}

class root_file{
	String root_file_loc;
	
	root_file()
	{
	System.out.println("Enter the location of the root directory");
	Scanner sc=new Scanner(System.in);
	this.root_file_loc=sc.nextLine();
	sc.close();
	}
}
public class file_explorer {

	public static void main(String[] args) {
		//String[] list_of_files=new String[10];
		root_file r=new root_file();
		//System.out.println(r.root_file_loc);
		File root=new File(r.root_file_loc);
		//System.out.println(root.list());
		String[] list_of_files=root.list();
		for(String s:list_of_files)
			System.out.println(s);
		
	}

}
