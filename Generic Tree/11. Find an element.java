public static boolean findElement(Node node, int data)
    {
        if(node.data == data)
            return true;
        
        for(Node child : node.children)
        {
            if(findElement(child, data))
                return true;
        }
        return false;
    }
