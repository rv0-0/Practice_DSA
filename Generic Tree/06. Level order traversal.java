public static void levelOrderTraversal(Node node)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size()>0)
        {
            Node rem = q.poll();
            System.out.println(rem.data);
            for(Node child :rem.children)
            {
                q.add(child);
            }
        }
    }
