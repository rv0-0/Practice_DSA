/*
* { "A", "C" },
* { "B", "C" },
* { "C", "F" },
* { "D", "E" },
* { "E", "F" },
* { "F", "F" } 
* 
* In this example C is manager of A, 
* C is also manager of B, F is manager 
* of C and so on.
*/

public static HashMap<String, Integer>  buildEmployeeTree(HashMap<String, String >map)
    {
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo="";

        for(String emp : map.keySet())
        {
            String man = map.get(emp);

            if(man.equals(emp))
            {
                ceo = man;
            }
            else if(tree.containsKey(man))
            {
                tree.get(man).add(emp);
            }
            else
            {
                HashSet<String> list = new HashSet<>();
                list.add(emp);
                tree.put(man,list);
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        findEmployeeCount(tree, ceo, result);
        return result;
    }

    private static int findEmployeeCount(HashMap<String, HashSet<String>> tree,String man,HashMap<String, Integer> result  )
    {
        if(tree.containsKey(man) == false)
        {
            result.put(man,0);
            return 1;
        }
        int sz = 0;
        for(String emp : tree.get(man))
        {
            int temp = findEmployeeCount(tree, emp, result);
            sz += temp;
        }
        result.put(man, sz);
        return sz+1;
    }

public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String >map = new HashMap<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String emp = sc.next();
            String man = sc.next();
            map.put(emp,man);
        }
        System.out.println(buildEmployeeTree(map));
    }
