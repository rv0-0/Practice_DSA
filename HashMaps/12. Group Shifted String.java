/*
* 1. You are given an array of strings.
* 2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other. 
* 3. Two strings s1 and s2 are shifted if -
*    - Length of both the strings is the same.
*    - The difference between ASCII values of every character of s1 and s2 is constant.
* 
* Note - Every string consists of lower-case English letters only. 
*/

public static ArrayList<ArrayList<String>> groupShiftedStrings(ArrayList<String> list)
    {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String word : list)
        {
            String key = makeCode(word);
            if(map.containsKey(key))
            {
                map.get(key).add(word);
            }
            else
            {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(word);
                map.put(key,temp);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(ArrayList group : map.values())
        {
            result.add(group);
        }
        return result;

    }
