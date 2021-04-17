public static int longestBitonic(int []arr)
    {
        int n=arr.length;
        int []dpr=new int[n];
        int []dpl=new int[n];
        dpr[0] = 1;
        for(int i=1;i<n;i++)
        {
            int max = 0;
            for(int k=0;k<i;k++)
            {
                if(arr[k]<=arr[i] && max<dpr[k])
                    max = dpr[k];
                dpr[i]=max+1;
            }
        }

        dpl[n-1] = 1;
        for(int i=n-2;i>=0;i--)
        {
            int max = 0;
            for(int k=n-1;k>i;k--)
            {
                if(arr[k]<=arr[i] && max<dpl[k])
                    max = dpl[k];
                dpl[i]=max+1;
            }
        }
        
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            ans = Math.max(ans, dpl[i]+dpr[i]-1);
        }
        return ans;
    }
