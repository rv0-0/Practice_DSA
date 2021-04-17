public static int longestRepeatingSubsequence(String A)
    {
        int row = A.length()+1;
        int col = A.length()+1;
        int [][]dp= new int [row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else
                {
                    if(A.charAt(i-1) == A.charAt(j-1) && i!=j)
                    {
                        dp[i][j] = 1+ dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }
