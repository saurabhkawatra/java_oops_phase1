import java.util.*;
public class ncr {
	
	int[] num= new int[50],numf;
	int count;
	
	void getnum()
	{
		int i=0;
		int x;
		Scanner s = new Scanner(System.in);
		while(true)
		{ 
			x=s.nextInt();
			if(x!=0)
			{num[i]=x;i++;count=i;}
			else
				break;
		}
		s.close();
		
		numf=new int[count];
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
            exp.findPowerSet(c.numf);
	}

}
