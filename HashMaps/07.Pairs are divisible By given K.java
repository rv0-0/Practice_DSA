public static boolean pairsDivisibleByK(int[] arr, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            int rem = arr[i]%k;
            map.put(rem, map.getOrDefault(rem,0)+1);
        }

        for(Integer val : arr)
        {
            int rem = val%k;

            if(rem==0)
            {
                if(map.get(rem)%2!=0)
                    return false;
            }
            else if(2*rem == k)
            {
                if(map.get(rem)%2!=0)
                    return false;
            }
            else
            {
                if(map.get(rem) != map.get(k-rem))
                    return false;
            }
        }
        return true;
    }
