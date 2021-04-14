import java.util.*;
public class ncr {
	
	double[] num= new double[50],numf;
	int count;
	
	void getnum()
	{
		int i=0;
		double x;
		Scanner s = new Scanner(System.in);
		while(true)
		{ 
			x=s.nextDouble();
			if(x!=0)
			{num[i]=x;i++;count=i;}
			else
				break;
		}
		s.close();
		
		numf=new double[count];
		for(i=0;i<count;i++)
			numf[i]=num[i];
	}
	
	void disp()
	{
	for(int i=0;i<count;i++)
		System.out.print(num[i]+"\t");
	System.out.println();
	}

	public static void main(String[] args) {
		
            ncr c= new ncr();
            System.out.println("Enter the Array");
            c.getnum();
            c.disp();
            setsofncr.main(c.numf);
	}

}

 class setsofncr{
public static void main(double[] s)
{
double sets[][]=new double[100][100];
int ncr;

for(int nofele=1;nofele<=s.length;nofele++)
{
          for(int ele=1;ele<=s.length;ele++)
          {
        	  if(ele>nofele) break;
        	  sets[nofele][ele]=s[0];
          }
           
	         
}

}
}