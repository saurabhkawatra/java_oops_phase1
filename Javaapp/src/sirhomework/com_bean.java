package sirhomework;

import java.util.Scanner;

class com_bean {
	int id;
	String name;
	int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString()
	{
		return("Id- "+id+" Name:- "+name+" Age:- "+age);
	}
	
	//Empty Constructor
	com_bean()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Name");
		name=sc.nextLine();
		System.out.println("Enter the age");
		age=Integer.parseInt(sc.nextLine());
	}
	//Parameterized Constructor
	com_bean(int id,String name,int age)
	{
		id=this.id;
		name=this.name;
		age=this.age;
	}

}
