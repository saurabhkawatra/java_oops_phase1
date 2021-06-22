//https://www.codechef.com/problems/TRICOIN
import java.util.Scanner;

public class coinsAndTriangle {
	private static int cal(int n)
	{
//		for(int i=1;i!=0;i++)
//		{
//			if(n>0)
//			{
//				n=n-i;
//			}
//			else
//			{
//				return(i-1);
//			}
//		}
		int i=1;
		while(n>=0)
		{
			n=n-i;
			i++;
		}
		return(i-2);
	}
	

	public static void main(String[] args) {
		int T;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		int[] N=new int[T];
		int[] Out=new int[T];
		for(int i=0;i<T;i++)
		{
			N[i]=sc.nextInt();
			Out[i]=cal(N[i]);			
		}
		for(int i=0;i<T;i++)
		{
			System.out.println(Out[i]);
		}
	}

}
