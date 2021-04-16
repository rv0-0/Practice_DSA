private static class Pair
    {
        int i;
        int j;
        String psf;
        Pair(int i, int j, String psf)
        {
            this.i=i;
            this.j=j;
            this.psf=psf;
        }
    }
    public static void zoKnapsac(int [] weight, int [] value, int capacity, int n)
    {
        int row = n+1;
        int col = capacity+1;
        int [][]dp = new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j =0 ;j<col;j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(weight[i-1]<=j)
                {
                    dp[i][j]  = Math.max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[row-1][col-1]);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row-1, col-1, ""));
        while(q.size()>0)
        {
            Pair rem = q.poll();
            if(rem.i==0 || rem.j==0)
            {
                System.out.println(rem.psf);
            }
            else
            {
                int exc = dp[rem.i-1][rem.j];

                if(exc == dp[rem.i][rem.j])
                {
                    q.add(new Pair(rem.i-1, rem.j, rem.psf));
                }

                if(weight[rem.i-1] <= rem.j)
                {
                    int inc = value[rem.i-1] + dp[rem.i-1][rem.j-weight[rem.i-1]];
                    if(inc == dp[rem.i][rem.j])
                        q.add(new Pair(rem.i-1, rem.j-weight[rem.i-1], rem.i-1+" "+rem.psf));
                }
            }
        }

    }
