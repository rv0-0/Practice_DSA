public static ArrayList<ArrayList<String>> groupAnagram(ArrayList<String> list)
    {
        HashMap<HashMap<Character, Integer>,ArrayList<String>> map = new HashMap<>();

        for(String word : list)
        {
            HashMap<Character, Integer> fmap = new HashMap<>();
            for(int i=0;i<word.length();i++)
            {
                Character c = word.charAt(i);
                fmap.put(c,fmap.getOrDefault(c,0)+1);
            }

            if(map.containsKey(fmap))
            {
                ArrayList<String> temp = map.get(fmap);
                temp.add(word);
                map.put(fmap, temp);
            }
            else
            {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(word);
                map.put(fmap, temp);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(ArrayList group : map.values())
        {
            result.add(group);
        }
        return result;

    }
