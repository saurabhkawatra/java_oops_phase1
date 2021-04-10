

class homework {

	public static void main(String[] args) {
		
              employeeTest.main(null);
	}

}


class employee {
	int id;   String name;   double salary;
	
	void display()
	{
		System.out.println("Employe Name is "+name+"\tEmployee Id is "+id+"\tEmployee Salary is "+salary);
	}
	void set(int id,String name,double salary)
	{
		this.id=id;   this.name=name;    this.salary=salary;
	}
	
		
}

class employeeTest{
	public static void main(String[] args)
	{
		employee e1,e2,e3;
		e1=new employee();   e2=new employee();  e3=new employee();
		e1.set(100, "Rakesh", 15000);   
		e2.set(101,"Jack", 11000);
		e3.set(102,"Daniel", 12000);
		e1.display();
		e2.display();
		e3.display();
	}
}