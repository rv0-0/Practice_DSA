public class Bridge implements Comparable<Bridge>
    {
        int n;
        int s;
        Bridge(int n,int s)
        {
            this.n=n;
            this.s=s;
        }
        public int compareTo(Bridge o)
        {
            if(this.n != o.n)
                return this.n -o.n;
            else
                return this.s-o.s;
        }
    }

    public void MaxNonOverlappingBridge(Bridge [] bdgs)
    {
        int n = bdgs.length;
        Arrays.sort(bdgs);

        int dp[] = new int[n];
        int omax = 0;
        for(int i=0;i<n;i++)
        {
            int max = 0;
            for(int j=0;j<i;j++)
            {
                if(bdgs[j].s <bdgs[i].s && dp[j]>max)
                {
                    max =dp[j];
                }
            }
            dp[i]= max+1;

            omax = Math.max(omax,dp[i]);
        }
    }
