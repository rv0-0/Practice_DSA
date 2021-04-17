public static class Pair
    {
        int i;
        int j;
        String psf;
        Pair(int i, int j, String psf)
        {
            this.i=i;
            this.j=j;
            this.psf = psf;
        }
    }
    public static void printSubSetSum(int []arr, int sum)
    {
        int row = arr.length+1;
        int col= sum+1;
        boolean[][] dp = new boolean[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = true;
                }
                else if(i==0)
                {
                    dp[i][j] = false;
                }
                else if (j==0)
                {
                    dp[i][j] = true;
                }
                else
                {
                    if(arr[i-1] <=j)
                    {
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }
                    else
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[row-1][col-1]);

        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(row-1,col-1,""));

        while(q.size()>0)
        {
            Pair rem = q.poll();
            if(rem.i ==0 || rem.j ==0)
            {
                System.out.println(rem.psf);
            }
            else
            {
                boolean exc = dp[rem.i-1][rem.j];
                if(exc == true)
                {
                    q.add(new Pair(rem.i-1,rem.j,rem.psf));
                }
                if(arr[rem.i-1]<=rem.j) {
                    boolean inc = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if(inc == true)
                    {
                        int val =rem.i-1;
                        q.add(new Pair(rem.i-1,rem.j-arr[rem.i-1],val+" "+rem.psf) );
                    }
                }
            }
        }


    }
