public static ArrayList<Character> commonElementII(String A, String B)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> res = new ArrayList<>();
        for(int i=0;i<A.length();i++)
        {
            Character c = A.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<B.length();i++)
        {
            Character c = B.charAt(i);
            if(map.containsKey(c))
            {
                res.add(c);
                int count = map.get(c);
                count--;
                if(count==0)
                    map.remove(c);
                else
                    map.put(c,count);
            }
        }
        return res;
    }
