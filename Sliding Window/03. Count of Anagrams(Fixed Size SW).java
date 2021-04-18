public static int countOfAnagrams(String A, String pat)
    {
        HashMap<Character, Integer> fmap = new HashMap<>();
        int charCount =0;
        for(int i=0;i<pat.length();i++)
        {
            Character c =pat.charAt(i);
            if(fmap.containsKey(c))
            {
                fmap.put(c,fmap.get(c)+1);
            }
            else
            {
                fmap.put(c,1);
                charCount++;
            }
        }
        int k =pat.length();

        int i=0;
        int j=0;
        int ans =0;
        while(j<A.length())
        {
            Character c= A.charAt(j);
            if(fmap.containsKey(c))
            {
                int val = fmap.get(c);
                val--;
                if(val==0)
                    charCount--;
                fmap.put(c,val);
            }
            if(j-i+1 < k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                if(charCount ==0)
                    ans++;

                Character t =A.charAt(i);
                if(fmap.containsKey(t))
                {
                    int val = fmap.get(t);
                    if(val ==0)
                        charCount++;
                    val++;
                    fmap.put(t, val);
                }

                i++;
                j++;
            }
        }
        return ans;
    }
