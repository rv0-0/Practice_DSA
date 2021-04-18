public int getMaxLenghtOfSum(int[] arr, int sum)
    {
        int i=0,j=0;
        int s=0;
        int res = Integer.MIN_VALUE;
        while(j<arr.length)
        {
            s+=arr[j];
            System.out.println(i+","+j+":"+s);

            if(s<sum)
                j++;
            else if(s==sum)
            {
                res = Math.max(res, j-i+1);
                 j++;

            }
            else if(s>sum)
            {
                while(s>sum)
                {

                     s -= arr[i];
                     i++;
                }
                if(s == sum)
                    res = Math.max(res, j-i+1);
                j++;
            }
        }
        return res;
    }
