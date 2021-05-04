package sirhomework;

import java.util.Scanner;

public class com_main {
	
	public static void main(String[] args)
	{
		com_service ser=new com_service();
		
		do
		{
			int x;
			Scanner sc=new Scanner(System.in);
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("3. Update age");
			System.out.println("4. Display using Id");
			System.out.println("5. Display all");
			System.out.println("6. Exit the Application");
			x=Integer.parseInt(sc.nextLine());
			switch(x){
					case 1:
					{
						ser.addCustomer();
						break;
					}
					case 2:
					{
						int input;
						System.out.println("Enter the id to remove");
						input=Integer.parseInt(sc.nextLine());
						ser.removeCustomer(input);
						break;
					}
					case 3:
					{
						int input,newage;
						System.out.println("Enter the id to update age");
						input=Integer.parseInt(sc.nextLine());
						System.out.println("Enter the new age");
						newage=Integer.parseInt(sc.nextLine());
						ser.updateAge(input, newage);
						break;
					}
					case 4:
					{
						int input;
						System.out.println("Enter the id for details");
						input=Integer.parseInt(sc.nextLine());
						ser.display(input);
						break;
					}
					case 5:
					{
						ser.displayAll();
						break;
					}
					case 6:
					{
						System.exit(0);
					}
			
			}
		}
		while(true);
		
	}
}
