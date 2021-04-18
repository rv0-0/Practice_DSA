public static int largestSubarrayWithSumZero(int []arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        map.put(sum,-1);
        int maxLen = 0;
        for(int i =0;i<arr.length;i++)
        {
            sum += arr[i];
            if(map.containsKey(sum))
            {
                int j = map.get(sum);
                int len = i-j;
                maxLen = Math.max(maxLen, len);
            }
            else
                map.put(sum,i);
        }
        return maxLen;
    }
