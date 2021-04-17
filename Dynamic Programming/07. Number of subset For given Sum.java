public static int numOfSubSetsForGivenSum(int [] arr,int sum)
    {
        int n = arr.length;
        int row = n+1;
        int col=sum+1;
        int [][] dp = new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = 1;
                }
                else if(i==0)
                {
                    dp[i][j] = 0;
                }
                else if(j==0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    if(arr[i-1] <=j)
                    {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
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
