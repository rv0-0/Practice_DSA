public class Envelope implements Comparable<Envelope>
    {
        int w,h;
        Envelope(int w, int h)
        {
            this.h=h;
            this.w=w;
        }
        public int compareTo(Envelope o)
        {
            return this.w - o.w;
        }
    }

    public void russianDollEnvelope(Envelope [] enlps)
    {
        int n = enlps.length;
        int omax = 0;
        int [] dp = new int[n];
        for(int i = 0;i<n;i++)
        {
            int max = 0;
            for(int j=0;j<i;j++)
            {
                if(enlps[j].h<enlps[i].h && enlps[j].w<enlps[i].w && dp[j]>max)
                {
                    max = dp[j];
                }
            }
            dp[i] = max+1;
            omax = Math.max(omax,dp[i]);
        }
    }
