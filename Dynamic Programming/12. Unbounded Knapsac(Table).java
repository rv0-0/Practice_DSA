public static int unboundedKnapsac(int []weight, int [] value, int capacity, int n)
    {
        int row = n+1;
        int col = capacity+1;
        int [][] dp = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (weight[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i][j - weight[i - 1]]);
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
