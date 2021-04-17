public static boolean equalSumPartition(int [] arr)
    {
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];

        if(sum %2!=0)
            return false;

        sum = sum/2;
        int row = n+1;
        int col=sum+1;
        boolean [][] dp = new boolean[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = true;
                }
                else if(i==0)
                {
                    dp[i][j] = false;
                }
                else if(j==0)
                {
                    dp[i][j] = true;
                }
                else
                {
                    if(arr[i-1] <=j)
                    {
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }
                    else
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[row-1][col-1];

    }
