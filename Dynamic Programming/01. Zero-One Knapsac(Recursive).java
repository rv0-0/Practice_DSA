  public static int zoKnapsac(int [] weight, int [] value, int capacity, int n)
    {
        if(capacity==0 || n==0)
            return 0;

        if(weight[n-1]<=capacity)
        {
            return Math.max(zoKnapsac( weight, value,  capacity,  n-1) ,value[n-1]+zoKnapsac( weight, value,  capacity-weight[n-1],  n-1));
        }
        else
        {
            return zoKnapsac( weight, value,  capacity,  n-1);
        }

    }
