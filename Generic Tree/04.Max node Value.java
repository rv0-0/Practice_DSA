public static int max(Node node)
    {
        int max = Integer.MIN_VALUE;

        for(Node child:node.children)
        {
            int temp = max(child);
            max = Math.max(max,temp);
        }

        max = Math.max(max,node.data);
        return max;
    }
