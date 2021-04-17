public static void insertionAndDeletion(String A, String B)
    {
        int subsequence = longestCommonSubsequence(A,B);
        int del = A.length() - subsequence;
        System.out.println("Deletion: " + del);
        int ins = B.length() - subsequence;
        System.out.println("Insertion: "+ins);
    }
    private static int longestCommonSubsequence(String A, String B)
    {
        int row = A.length()+1;
        int col =B.length()+1;
        int [][] dp = new int [row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else
                {
                    if(A.charAt(i-1) == B.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[row-1][col-1];

    }
