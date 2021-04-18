public static int longestConsecutiveSequence(int []arr)
    {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int maxCount= Integer.MIN_VALUE;;
        for(int i=0;i<arr.length;i++)
            map.put(arr[i],true);

        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]-1))
                map.put(arr[i],false);
        }

        for(Integer value : map.keySet())
        {
            if(map.get(value) == true)
            {
                int start = value;
                int count=1;
                start++;
                while(map.containsKey(start))
                {
                    count++;
                    start++;
                }
                maxCount = Math.max(maxCount,count);
            }
        }
        return maxCount;

    }
