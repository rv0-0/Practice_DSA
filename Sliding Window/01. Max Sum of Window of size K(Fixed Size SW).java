public static int maximumSumSubarray(int []arr, int k)
    {
        int i=0;
        int j=0;
        int sum=0;
        int maxSum= Integer.MIN_VALUE;
        while(j<arr.length)
        {
            sum += arr[j];

            if(j-i+1 <k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;

    }
