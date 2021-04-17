public static int rodCutting(int []price, int maxLength)
    {
        int []length = new int[maxLength];
        for(int i=1;i<=maxLength;i++)
            length[i-1]=i;

        int row = price.length+1;
        int col = maxLength+1;

        int [][]dp = new int[row][col];

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (length[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i-1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }
