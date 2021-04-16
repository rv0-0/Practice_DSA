public static ArrayList<Integer> nodeToRootPath(Node node, int data)
    {
        if(node.data == data)
        {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(node.data);
            return a;
        }

        for(Node child : node.children)
        {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if(ptc.size()>0)
            {
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }
