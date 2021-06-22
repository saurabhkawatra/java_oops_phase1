// https://www.codechef.com/problems/DSTAPLS
import java.util.Scanner;

public class DistributeApples {

	public static void main(String[] args) {
		int T=0;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		double[] N=new double[T];
		double[] K=new double[T];
		String[] Out=new String[T];
		for(int i=0;i<T;i++)
		{
			N[i]=sc.nextDouble();
			K[i]=sc.nextDouble();
			
				if((N[i]/K[i])%K[i]==0)
				{
				Out[i]="NO";
				}
			else
				{
				Out[i]="YES";
				}
			
		}
		
		for(int i=0;i<T;i++)
			System.out.println(Out[i]);
		
	}

}
