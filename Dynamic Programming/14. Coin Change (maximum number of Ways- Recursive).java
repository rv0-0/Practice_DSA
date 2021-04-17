public static int coinChangeMaximum(int []coins, int sum, int n)
    {
        if(n==0 && sum ==0)
            return 1;
        if(n == 0 )
            return 0;
        if( sum == 0)
            return 1;
       if(coins[n-1]<= sum)
           return coinChangeMaximum(coins, sum, n-1) + coinChangeMaximum(coins, sum-coins[n-1], n);
       else
           return coinChangeMaximum(coins, sum, n-1);
    }
