/*
* You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.*
* One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
* Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
* Note: You cannot rotate an envelope.
*/

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
