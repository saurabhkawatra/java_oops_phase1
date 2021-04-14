public class exp
{
	public static int fact(int i)
	{
		if(i==1)
			return 1;
		int fact=i;
		fact=fact*fact(i-1);
		return fact;
	}
    public static void findPowerSet(int[] S)
    {
    	
        int N = (int) Math.pow(2, S.length),c=0;
        int[] buf=new int[S.length+1];
     
        for (int i = 0; i < N; i++)
        {
           c=0;
            for (int j = 0; j < S.length; j++)
            {
                // if j'th bit of `i` is set, print `S[j]`
                if ((i & (1 << j)) != 0) {
                System.out.print(S[j] + " ");c++;buf[c]=S[j];
                }
            }
            System.out.println();
            
        }
    }
 
    public static void main(String[] args)
    {
       // int[] S = { 1, 2, 3 };
       // findPowerSet(S);
    	int f=4,z;
    	z=exp.fact(f);
    	System.out.print(z);
    }
}