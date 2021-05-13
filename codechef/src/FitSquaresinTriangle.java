// https://www.codechef.com/submit/TRISQ

import java.util.Scanner;

public class FitSquaresinTriangle {
	
	static int APsum(int N)
	{
		int sum=0;
		for(int i=1;i<=N;i++)
			sum=sum+i;
		return(sum);
	}

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
			int B[]=new int[T];
			int R[]=new int[T];
			for(int i=0;i<T;i++)
			{
				B[i]=sc.nextInt();
				
				if(B[i]<1&&B[i]>10000)
				{
					System.out.println("Invalid Constraint");
					break;
				}
				else
				{
					int length=B[i];
					int N=0;
					if(length%2==0)
					{
						N=(length-2)/2;
						R[i]=APsum(N);
					}
					else
					{
						N=(length-2)/2;
						R[i]=APsum(N);
					}
				}
			}
			
			for(int i=0;i<T;i++)
			{
				System.out.println(R[i]);
			}
		}

	}

}
