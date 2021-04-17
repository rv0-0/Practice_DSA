public static class Pair
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
    public static void longestCommonSubsequence(String A, String B)
    {
        int row = A.length()+1;
        int col =B.length()+1;
        int [][] dp = new int [row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else
                {
                    if(A.charAt(i-1) == B.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row-1,col-1,""));

        while(q.size()>0)
        {
            Pair rem = q.poll();
            if(rem.i==0 || rem.j==0)
            {
                System.out.println(rem.psf);
            }
            else
            {
                if(A.charAt(rem.i-1) == B.charAt(rem.j-1))
                {
                    q.add(new Pair(rem.i-1,rem.j-1, A.charAt(rem.i-1)+" "+rem.psf ));
                }
                else
                {
                    if(dp[rem.i-1][rem.j] > dp[rem.i][rem.j-1])
                        q.add(new Pair(rem.i-1,rem.j,rem.psf));
                    else
                        q.add(new Pair(rem.i,rem.j-1,rem.psf));
                }
            }

        }

    }
