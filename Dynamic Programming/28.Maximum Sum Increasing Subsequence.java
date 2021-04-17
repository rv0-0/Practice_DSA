public static int maxSumIncreasingSubsequence(int []arr)
    {
        int n=arr.length;
        int []dp= new int[n];
        dp[0]=arr[0];
        int overAllMax = Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            int sum=0;
            for(int k=0;k<i;k++)
            {
                if(arr[k]<=arr[i] && sum<dp[k])
                {
                    sum = dp[k];
                }
                dp[i]=sum+arr[i];
                overAllMax = Integer.max(overAllMax, dp[i]);
            }
        }
        return overAllMax;
    }
