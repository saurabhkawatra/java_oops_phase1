package JDBC_Practise;
import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;

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
			System.out.println("\n\nCreate new entry for the table Employee");
			System.out.print("Enter the Emp_id:- ");temp=sc.nextLine();
			emp_id=Integer.parseInt(temp);
			System.out.print("\nEnter the Employee Name:- ");Employeename=sc.nextLine();
			System.out.println("\nEnter Employee's Salary:- ");temp=sc.nextLine();
			Salary=Integer.parseInt(temp);
			System.out.println("insert into Employee (Emp_Id,EmployeeName,Salary) values ("+emp_id+",'"+Employeename+"',"+Salary+");");
			
			stmt.executeUpdate("insert into Employee (Emp_Id,EmployeeName,Salary) values ("+emp_id+",'"+Employeename+"',"+Salary+");");
			
			System.out.println();
			System.out.println("\nTable Employee :-");
			System.out.printf("\n%-6s %-30s %-30s","Emp_ID","EmployeeName","Salary");
			rs=stmt.executeQuery("Select * from Employee");
			while(rs.next())
			{
				System.out.printf("\n%-6s %-30s %-30s",rs.getInt(1),rs.getString(2),rs.getInt(3));
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

