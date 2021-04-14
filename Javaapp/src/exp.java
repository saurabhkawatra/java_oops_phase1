public class exp
{
	public static int fact(int i)
	{
		if(i==0)
			return 1;
		if(i==1)
			return 1;
		int fact=i;
		fact=fact*fact(i-1);
		return fact;
	}
    public static void findPowerSet(int[] S)
    {
    	
        int N = (int) Math.pow(2, S.length),c=0;
        int[] buf=new int[S.length];
        int[][][] x=new int[100][100][100];
        
        for(int r=1;r<=S.length;r++)
        {
        	int ca=0;
                  for (int i = 0; i < N; i++)
                       {
                           c=0;
                           for (int j = 0; j < S.length; j++)
                                {
                                 // if j'th bit of `i` is set, print `S[j]`
                                  if ((i & (1 << j)) != 0) {
                                 buf[c]=S[j];System.out.print(S[j] + " ");c++;
                                 }
                                }
                         if(c==r)
                         { for(int z=0;z<c;z++)
                         x[r][ca][z]=buf[z];
                         ca++;}
                         System.out.println();
            
                       }
        }
        
        for(int i=1;i<=S.length;i++)
        {
        	System.out.println(i+" elements selected at a time");
        	for(int j=0;j<(exp.fact(S.length)/exp.fact(i)/exp.fact(S.length-i));j++)
        	{
        		for(int k=0;k<i;k++)
        			System.out.print(x[i][j][k]+" ");
        		System.out.println();
        	}
        }
    }
 
    public static void main(String[] args)
    {
       int[] S = { 1, 2, 3, 4 };
       findPowerSet(S);
    	int f=4,z;
    	z=exp.fact(f);
    	System.out.print(z);
    }
}