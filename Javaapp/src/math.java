import java.util.*;
//question - https://www.hackerrank.com/challenges/java-loops/problem
public class math {

	public static void main(String[] args) {
		int q=0,rem,c=0;
		int[] a,b,n;
		a=new int[500];
		b=new int[500];
		n=new int[15];
		Scanner sc = new Scanner(System.in);
		
		while(c==0)
		{
		int er=0;
		System.out.println("Enter the value of q\n");
		q=sc.nextInt();if(q>500||q<0) {System.out.println("q should be betweeen 1 and 500\n");continue;}
		for(int i=0;i<q;i++)
		{
		System.out.print("Enter the value of a\n");
		a[i]=sc.nextInt();if(a[i]<0||a[i]>50) {System.out.println("a should be betweeen 0 and 50\n");er++;break;};
		System.out.println("Enter the value of b");
		b[i]=sc.nextInt();if(b[i]<0||b[i]>50) {System.out.println("b should be betweeen 0 and 50\n");er++;break;};;
		System.out.println("Enter the value of n");
		n[i]=sc.nextInt();if(n[i]<1||n[i]>15) {System.out.println("n should be betweeen 1 and 15\n");er++;break;};;
		}
		if(er==0)
		c++;
		}
		
		
		for(int o=0;o<q;o++)
		{
			int[] s = new int[n[o]];
		for(int i=0;i<n[o];i++)
		{
			rem=0;
			for(int j=0;j<i+1;j++) {
			rem=rem + b[o] * (int)(Math.pow(2,j));}
			s[i]=a[o]+rem;
		}
		for (int i=0;i<s.length;i++)
			System.out.print(s[i]+"\t");
		System.out.println();
		}
		sc.close();
	}

}
