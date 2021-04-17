public static int longestIncreasingSubsequence(int []arr)
    {
        int n=arr.length;
        int []dp= new int[n];
        dp[0]=1;
        int overaAllmax = Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            int max = 0;
            for(int k=0;k<i;k++)
            {
                if(arr[k]<=arr[i] && max<dp[k])
                {
                    max = dp[k];
                }
            }
            dp[i] = max+1;
            overaAllmax = Math.max(overaAllmax,dp[i]);
        }
        return overaAllmax;
    }
