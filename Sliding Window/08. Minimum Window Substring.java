public int MinimumWindowSubstring(String s, String t)
    {
        Map<Character,Integer> m = new HashMap<>();
        int lettecount = 0;
        for(int i=0;i<t.length();i++) {
            Character c = t.charAt(i);
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else {
                m.put(c, 1);
                lettecount++;

            }
        }

        int res = Integer.MAX_VALUE;

        int i=0,j=0;
        int st=0,e=0;
        while(j<s.length())
        {
            Character c = s.charAt(j);
            if(m.containsKey(c))
            {
                int val = m.get(c);
                val--;
                if(val==0)
                    lettecount--;
                m.put(c,val);
            }

            if(lettecount == 0)
            {
                while(lettecount==0)
                {
                    Character cc = s.charAt(i);
                    if(m.containsKey(cc))
                    {
                        int val = m.get(cc);
                        if(val==0)
                        {
                            if(res>j-i+1)
                            {
                                res =j-i+1;
                                st= i;
                                e=j+1;

                            }
                            m.put(cc,val+1);
                            lettecount++;
                        }
                        else if(val<0)
                            m.put(cc,val+1);

                        i++;
                    }
                    else
                    {
                        i++;
                    }
                }
                j++;
            }
            else if(lettecount >0)
            {
                j++;
            }

        }
        System.out.println(s.substring(st,e));
        return res;

    }
