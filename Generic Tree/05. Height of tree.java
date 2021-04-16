public static int height(Node node)
    {
        int ht = -1;
        for(Node child: node.children)
        {
            int temp = height(child);
            ht = Math.max(temp,ht);
        }
        ht +=1;
        return ht;
    }
