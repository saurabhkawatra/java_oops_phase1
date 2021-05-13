//https://www.codechef.com/problems/FLOW007

import java.util.Scanner;

public class reversethenumber {

	public static void main(String[] args) {
		int T;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		if(T>1000&&T<1)
		{
			System.out.println("Constraint broken");
		}
		else
		{
			int[] N=new int[T];
			int[] R=new int[T];
			for(int i=0;i<T;i++)
			{
				N[i]=sc.nextInt();
			}
			for(int i=0;i<T;i++)
			{
				int num=N[i],rem=0,quotient=1,counter=0,sum=0;
				while(num!=0)
				{
					counter++;
					num=num/10;
				}
				num=N[i];
				while(counter!=0)
				{
					counter--;
					rem=num%10;
					num=num/10;
					sum=sum+(int)(rem*Math.pow(10,counter));
				}
				R[i]=sum;
			}
			for(int i:R)
			{
				System.out.println(i);
			}
		}
		
	}

}
