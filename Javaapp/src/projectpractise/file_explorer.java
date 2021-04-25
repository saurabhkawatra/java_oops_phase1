package projectpractise;
import java.io.*;
import java.util.*;


class homescreen{
	int option;
	String confirm,name;
	
	void options(String s)
	{
		File newfile=new File(s);
		while(true)
		{
		System.out.println("---------Main Menu----------------------------------\n");
		System.out.println("You are in directory : "+s+"\n");
		System.out.println("Select the Option among the following operations to perform in the directory");
		System.out.println("1. List all the files in the directory in the Ascending order");
		System.out.println("2. Create a New File in the Directory");
		System.out.println("3. Delete an Existing File in the Directory");
        System.out.println("4. Search for a file in the directory by name( Use Filename.extension )");
        System.out.println("5. Enter New Directory Location");
		System.out.println("6. Exit the application");
		System.out.print("\nType your Selection Here--->");
		try {
		Scanner sc=new Scanner(System.in);
		this.option=sc.nextInt();
		System.out.println("\nOption Selected >>>>>>>>>>>>> "+this.option);
		}
		catch(Exception e)
		{
		   System.out.println("\nInvalid Input, Please try again with a Numeric Input!");
		   options(s);
		}
		if(option==1)
		{
			
		}
		else if(option==2)
		{
			while(true)
			{
			System.out.println("\nOption chosen to Add a file in the directory ["+s+"]");
			System.out.println("Please type 'Yes' if you wish to proceed, or type 'No' to go back to the previous Menu Options");
			Scanner sc=new Scanner(System.in);
			confirm=sc.nextLine();
			if(confirm.matches("[Y|y][e|E][s|S]"))
			{
				while(true)
				{
			System.out.println("\n"+"Enter the name that you'd like to keep for the New File");
			name=sc.nextLine();
			System.out.println("name="+name);
			   if(name.matches("([^(\\\\|/|:|?|*|<|>|||\")*])*")) //pattern to accept any character other than \ / ? < > \ " | * 
				{
				   String g=s.concat("\\"+name);
					File F=new File(g);
					System.out.println("g="+g);
					if(F.exists())
					{
						System.out.println("A File already exists with a same name.");
						System.out.println("Please try with a different name.");
						continue;
					}
					else
				  {
					try {
					F.createNewFile();
					}catch(IOException e)
					{
					System.out.println("Exception occured."+e);
					}
					if(F.exists())
					{
						System.out.println("File has been created. File name :- "+name);
						break;
					}
					else
					{
						System.out.println("File not created due to an unknown issue. Please Try again!");
					}
				  }
				}
				else
				{
					System.out.println("File name cannot contain characters \\ / ? < > \" | * : ");
					System.out.println("Please enter a different name which do not contain these characters");
					continue;
					
				}
			}
				break;
			}
			else if(confirm.matches("[n|N][o|O]"))
			{
				break;
			}
			else
			{
				System.out.println("Invalid Response! Please confirm Once again.");
				continue;
			}
				
			}
		}
		else if(option==3)
		{
			
		}
		else if(option==4)
		{
			
		}
		
		else if(option==5)
		{
			break;
		}
		else if(option==6)
		{
			System.out.println();
			System.out.println("Thank you for using the Application!");
			System.exit(0);
		}
		else
		{
			System.out.println("This option does not exist! Please Try again.");
		}
	}
	}
	homescreen(String s)
	{
	      options(s);
	}
}

class root_file{
	String root_file_loc;
	
	void set_root_file_loc()
	{
		System.out.println("Enter the location of the root directory");
		Scanner sc=new Scanner(System.in);
		this.root_file_loc=sc.nextLine();
	}
	
	
}
public class file_explorer {
	
	void main()
	{
		root_file r=new root_file();
		r.set_root_file_loc();
        
		File root=new File(r.root_file_loc);                //System.out.println(root.canRead());
		
		while(root.canRead()==false)
		{
			System.out.println("Invalid Directory Path! Please Try Again!\n");
			r.set_root_file_loc();
	        
			root=new File(r.root_file_loc);
		}
		System.out.println();
		System.out.println("Files in the Directory ["+r.root_file_loc+"] are :-");
		System.out.println();
		String[] list_of_files=root.list();
		for(String s:list_of_files)
			System.out.println("File:"+s);
        System.out.println();
		homescreen h=new homescreen(r.root_file_loc);
	}

	public static void main(String[] args) {
		
	 System.out.println("Welcome to the File Explorer Application");
		while(true)
		{
			file_explorer fe=new file_explorer();
			fe.main();
		}
		
		                                                                		
	}

}
