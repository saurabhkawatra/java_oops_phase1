package JDBC_Practise;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class employee {
	private int emp_id;
	private String Name;
	private int salary;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "employee [emp_id=" + emp_id + ", Name=" + Name + ", salary=" + salary + "]";
	}
}

public class oracledatabase {

	public static void main(String[] args) {
		
		System.out.println("\n\t Display all tables :- \n");
		Scanner sc=new Scanner(System.in);
		int emp_id,Salary;
		String Employeename,temp;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dattago1");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from oracle_sql_login");
			System.out.println("Table oracle_sql_login :-");
			System.out.printf("\n%-30s %-30s %-30s","Loginname","LoginPassword","UserName");
			while(rs.next())
			{
				System.out.printf("\n%-30s %-30s %-30s",rs.getString(1),rs.getString(2),rs.getString(3));
			}
			System.out.println();
			System.out.println("\nTable Employee :-");
			System.out.printf("\n%-6s %-30s %-30s","Emp_ID","EmployeeName","Salary");
			rs=stmt.executeQuery("Select * from Employee");
			while(rs.next())
			{
				System.out.printf("\n%-6s %-30s %-30s",rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
			System.out.println("\n\nWould you like to add an entry to the employee list");
			System.out.println(" Yes or No ");
			String in=sc.nextLine();
			if(in.matches("[Y|y][e|E][s|S]"))
			{
				System.out.println("\n\nCreate new entry for the table Employee");
				System.out.print("Enter the Emp_id:- ");temp=sc.nextLine();
				emp_id=Integer.parseInt(temp);
				System.out.print("\nEnter the Employee Name:- ");Employeename=sc.nextLine();
				System.out.println("\nEnter Employee's Salary:- ");temp=sc.nextLine();
				Salary=Integer.parseInt(temp);
				System.out.println("insert into Employee (Emp_Id,EmployeeName,Salary) values ("+emp_id+",'"+Employeename+"',"+Salary+")");
				
				stmt.executeUpdate("insert into Employee (Emp_Id,EmployeeName,Salary) values ("+emp_id+",'"+Employeename+"',"+Salary+")");
				
			}
			
			
			System.out.println();
			System.out.println("\nTable Employee :-");
			System.out.printf("\n%-6s %-30s %-30s","Emp_ID","EmployeeName","Salary");
			rs=stmt.executeQuery("Select * from Employee");
			while(rs.next())
			{
				System.out.printf("\n%-6s %-30s %-30s",rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
			List<employee> emp_list=new ArrayList<>();
			rs=stmt.executeQuery("Select * from employee");
			while(rs.next())
			{
				employee e1=new employee();
				e1.setEmp_id(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setSalary(rs.getInt(3));
				emp_list.add(e1);
			}
			System.out.println("\n\nPrinting from the list\n");
		
			for(employee e:emp_list)
			{
				System.out.println(e.toString());
			}
			
		}catch(ClassNotFoundException c)
		{
			System.out.println(c);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

}

