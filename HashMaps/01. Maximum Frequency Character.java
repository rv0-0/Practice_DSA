public static Character maxCharFrequency(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int max = Integer.MIN_VALUE;
        Character res = s.charAt(0);
        for(Character c : map.keySet())
        {
            int val = map.get(c);
            if(max<val)
            {
                max = val;
                res = c;
            }
        }
        return res;
    }
