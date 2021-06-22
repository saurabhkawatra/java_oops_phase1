//https://www.codechef.com/problems/GDOG
import java.util.Scanner;

public class greedypuppy {

	public static void main(String[] args) {
		int T;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		int N[]=new int[T];
		int K[]=new int[T];
		int op[]=new int[T];
		for(int i=0;i<T;i++)
		{
			N[i]=sc.nextInt();
			K[i]=sc.nextInt();
			int max=0;
			for(int j=1;j<=K[i];j++)
			{
			    if(max<(N[i]%j))
			    max=N[i]%j;
			}
			op[i]=max;
		}
		for(int i=0;i<T;i++)
		{
			System.out.println(op[i]);
		}

	}

}
