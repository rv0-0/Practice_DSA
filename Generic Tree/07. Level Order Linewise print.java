public static void levelOrderLineWise(Node node)
    {
        Queue<Node> mq = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        mq.add(node);

        while(mq.size()>0)
        {
            Node rem = mq.poll();
            System.out.print(rem.data+" ");

            for(Node child: rem.children)
                cq.add(child);

            if(mq.size()==0)
            {
                mq=cq;
                cq = new LinkedList<>();
                System.out.println();
            }
        }
    }
