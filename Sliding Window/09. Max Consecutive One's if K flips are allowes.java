public static int maxConsecutiveOne(int [] arr, int k)
    {
        int i=0;
        int j =0;
        int flips =0;
        int res =0;
        while (j<arr.length)
        {
            if(arr[j] == 0)
                flips ++;

            if(flips<k)
                j++;
            else if(flips == k || j==arr.length-1)
            {
                res= Math.max(res, j-i+1);
                j++;
            }
            else if(flips>k)
            {
                while(flips>k)
                {
                    if(arr[i]==0)
                        flips--;
                    i++;
                }
                j++;
            }


        }
        return res;
    }
