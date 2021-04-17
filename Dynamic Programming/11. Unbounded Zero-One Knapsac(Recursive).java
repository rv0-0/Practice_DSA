public static int unboundedKnapsac(int []weight, int [] value, int capacity, int n)
    {
        if(capacity ==0 || n==0)
            return 0;
        if(weight[n-1]<=capacity)
            return Math.max(unboundedKnapsac(weight, value, capacity, n-1), value[n-1]+unboundedKnapsac(weight, value, capacity-weight[n-1], n));
        else
            return unboundedKnapsac(weight, value, capacity, n-1);
    }
