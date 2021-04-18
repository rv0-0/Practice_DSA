public int getKUniquieLength(String s, int k)
    {
        Map<Character, Integer> m =new HashMap<>();

        int i=0,j=0;
        int res = Integer.MIN_VALUE;

        while(j<s.length())
        {
            Character c = s.charAt(j);

            if(m.containsKey(c))
                m.put(c, m.get(c)+1);
            else
                m.put(c,1);

            if(m.size()<k)
                j++;
            else if(m.size() == k)
            {
                res = Math.max(res,j-i+1);
                j++;
            }
            else if(m.size()>k)
            {
                while(m.size()>k)
                {

                    Character cc = s.charAt(i);
                    if(m.containsKey(cc)) {
                        int val = m.get(cc);
                        val--;
                        if (val == 0)
                            m.remove(cc);
                        else
                            m.put(cc, val);
                    }
                    i++;
                }
                if(m.size() == k)
                    res = Math.max(res,j-i+1);
                j++;
            }
        }
        return res;
    }
