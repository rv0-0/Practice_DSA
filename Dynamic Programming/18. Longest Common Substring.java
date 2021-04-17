public static int longestCommonSubstring(String A, String B)
    {
        int row = A.length()+1;
        int col =B.length()+1;
        int [][] dp = new int [row][col];
        int max = Integer.MIN_VALUE;
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
                        dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
