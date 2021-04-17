/*
*Partition a set into two subsets such that the difference of subset sums is minimum
*/
public static int minimumSubSetSumDifference(int []arr)
    {
        int range=0;
        for(int x:arr)
            range += x;
        int row= arr.length+1;
        int col=range+1;
        boolean [][]dp = new boolean[row][col];

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0)
                    dp[i][j] = true;
                else {
                    if (arr[i - 1] <= j)
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<col/2;j++)
        {
            if(dp[row-1][j])
            {
                min = Math.min(min, range - (2*j) );
            }
        }
        return min;
    }
