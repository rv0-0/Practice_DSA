public static int countOfZeroSumSubArray(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        map.put(sum,1);
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];
            if(map.containsKey(sum))
            {
                count += map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
            else
            {
                map.put(sum,1);
            }
        }
        return count;
    }
