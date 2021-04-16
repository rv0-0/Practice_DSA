public static void linearize(Node node)
    {
        for(Node child: node.children)
            linearize(child);
        
        while(node.children.size()>1)
        {
            Node lastChild = node.children.remove(node.children.size()-1);
            Node secondLastChild = node.children.get(node.children.size()-1);
            Node secondLastTail = getTail(secondLastChild);
            secondLastTail.children.add(lastChild);
        }
    }
    private static Node getTail(Node node)
    {
        while(node.children.size()==1)
            node = node.children.get(0);
        return node;
    }
