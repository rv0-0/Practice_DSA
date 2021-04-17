public static int coinChangeMaximum(int []coins, int sum, int n)
    {
        int rows = n+1;
        int col = sum+1;
        int [][]dp=new int[rows][col];

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else if (i == 0)
                    dp[i][j] = 0;
                else if (j == 0)
                    dp[i][j] = 1;
                else {
                    if (coins[i - 1] <= j)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[rows-1][col-1];
    }
