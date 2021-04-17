public static int coinChangeMinimunNumberOfCoin(int []coins, int sum, int n)
    {
        int row = n+1;
        int col = sum+1;
        int [][]dp = new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = 0;
                else if(i==0)
                    dp[i][j] = Integer.MAX_VALUE-1;
                else if(j==0)
                    dp[i][j] = 0;
                else
                {
                    if(coins[i-1]<=j)
                        dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
