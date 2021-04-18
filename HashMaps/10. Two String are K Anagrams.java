/*
* 1. You are given two strings s1, s2, and a number K.
* 2. You have to find if two strings are K-anagrams of each other or not.
* 3. Two strings are called K-anagrams if 
*    - Both s1 and s2 have the same number of characters.
*   - After changing K characters in any string, s1 and s2 become anagram of each other. 
* 
* Note - Both s1 ad s2 consist of lowercase English letters only.
*/
public static boolean kAnagram(String A, String B, int k)
    {
        if(A.length() != B.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<A.length();i++)
            map.put(A.charAt(i) , map.getOrDefault(A.charAt(i),0)+1);
        for(int i=0;i<B.length();i++)
        {
            Character c = B.charAt(i);
            if(map.containsKey(c))
            {
                int val = map.get(c);
                if(val>0)
                    val--;
                map.put(c,val);
            }
        }
        int s=0;
        for(Character c:map.keySet())
        {
            int val = map.get(c);
            s +=val;
            if(s>k)
                return false;
        }
        return true;
    }
