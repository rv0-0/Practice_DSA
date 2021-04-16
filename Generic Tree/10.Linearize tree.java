//Approch 1 O(n2)
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
//Approch 2 O(n)
public static Node linearize2(Node node)
    {
        if(node.children.size() == 0)
            return node;
        Node lkt = linearize2(node.children.get(node.children.size()-1));
        while(node.children.size()>1)
        {
            Node last = node.children.remove(node.children.size()-1);
            Node secondlast = node.children.get(node.children.size()-1);
            Node secondlastTail  = linearize2(secondlast);
            secondlastTail.children.add(last);
        }
        return lkt;
    }
