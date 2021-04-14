public class powerset1
{
    public static void findPowerSet(int[] S)
    {
        // `N` stores the total number of subsets
        int N = (int) Math.pow(2, S.length);
        // generate each subset one by one
        for (int i = 0; i < N; i++)
        {
            // check every bit of `i`
            for (int j = 0; j < S.length; j++)
            {
                // if j'th bit of `i` is set, print `S[j]`
                if ((i & (1 << j)) != 0) {
                    System.out.print(S[j] + " ");
                }
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };
        findPowerSet(S);
    }
}