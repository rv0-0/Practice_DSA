    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccesor(Node node,int data, int state)
    {
        if(state == 0)
        {
            if(node.data==data)
                state++;
            else
                predecessor = node;
        }
        else if(state==1)
        {
            successor = node;
            state++;
        }
        for(Node child : node.children)
            predecessorAndSuccesor(node, data, state);
    }
