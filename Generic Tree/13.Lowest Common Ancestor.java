public static int lowestCommonAncestor(Node root, int d1, int d2)
    {
        ArrayList<Integer> p1 = nodeToRootPath(root, d1);
        ArrayList<Integer> p2 = nodeToRootPath(root, d2);
        int i = p1.size()-1;
        int j = p2.size()-1;
        while(i>=0 && j>=0 && p1.get(i) == p2.get(j))
        {
            i--;
            j--;
        }
        i++;
        return p1.get(i);
    }
