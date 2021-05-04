package sirhomework;

import java.util.ArrayList;
import java.util.List;

public class com_service {
	
	List<com_bean> CustomerObjects = new ArrayList<com_bean>(); 
	
	void addCustomer()
	{
		int idcheck=0,custadded=0;
		com_bean c=new com_bean();
		for(com_bean e:CustomerObjects)
			if(e.id==c.id)
			{
				idcheck=1;
			}
				
		if(idcheck!=1&&c.age>=21)
		{
			CustomerObjects.add(c);
			System.out.println("Customer Added");
			custadded=1;
		}
		
	    if(idcheck==1)
		{
			System.out.println("Id already exists!");
		}
		else if(c.age<21)
		{
			System.out.println("Age cannot be less than 21!");
		}	
	}
	void removeCustomer(int deleteid)
	{
		int check=0;
		for(com_bean e:CustomerObjects)
		{
			if(e.id==deleteid)
			{
				CustomerObjects.remove(CustomerObjects.indexOf(e));
				check=1;
				System.out.println("Customer removed from list!");
			}
				
		}
		if(check==0)
		{
			System.out.println("Id not found");
		}
	}
	void updateAge(int id,int newage)
	{
		for(com_bean e:CustomerObjects)
			if(e.id==id)
			{
				if(e.age<newage)
				{
					e.age=newage;
					System.out.println("Age Updated");
				}
				else
					System.out.println("Age cannot be less than the previous age");
				
			}
		
	}
	void display(int id)
	{
		for(com_bean e:CustomerObjects)
		{
			if(e.id==id)
			{
				System.out.println(e.toString());
			}
		}
	}
	void displayAll()
	{
		for(com_bean e:CustomerObjects)
			System.out.println(e.toString());
	}
	
}
