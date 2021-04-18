public int longestSubstringWithoutRepeatingCharacter(String s)
    {
        int i=0;
        int j=0;
        Map<Character,Integer> m = new HashMap<>();
        int  res = Integer.MIN_VALUE;


        while(j<s.length())
        {
            Character c = s.charAt(j);


            if(m.containsKey(c)) {
                int val = m.get(c);
                val++;
                m.put(c, val);
            }
            else {
                m.put(c, 1);
            }


            if(m.size() == j-i+1)
            {
                System.out.println(m);
                res = Math.max(res, j-i+1);
                j++;
            }
            else if(m.size()<j-i+1)
            {
                while (m.size()<j-i+1)
                {
                    System.out.println(m);
                    Character cc = s.charAt(i);
                    int v = m.get(cc)-1;
                    if(v==0)
                        m.remove(cc);
                    else
                        m.put(cc , v);
                    i++;
                }
                j++;
            }
        }
        return res;
    }
