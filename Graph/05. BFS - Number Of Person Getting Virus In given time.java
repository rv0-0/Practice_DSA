/*
* 1. You are given a graph, representing people and their connectivity.
* 2. You are also given a src person (who got infected) and time t.
* 3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.
*/

import java.util.*;

public class Main {
    public static class Edge
    {
        int v,wt;
        Edge( int v, int wt)
        {
            this.v=v;
            this.wt=wt;
        }
    }
    public static void main(String [] args)
    {
        HashMap<Integer, ArrayList<Edge>> g = new HashMap<>();
        int n,e;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        e=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            g.put(i,new ArrayList<Edge>());
        }

        for(int i=0;i<e;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            g.get(u).add(new Edge(v,1));
            g.get(v).add(new Edge(u,1));
        }

        int src = sc.nextInt();
        int t = sc.nextInt();
        int count=0;
        Queue<Pair> q= new LinkedList<>();
        int []visited = new int[n];
        q.add(new Pair(src, 1));

        while(q.size()>0)
        {
            Pair rem = q.poll();

            if(visited[rem.v] !=0)
                continue;
            visited[rem.v] = rem.time;
            if(count>t)
                break;
            count++;
            for(Edge neigh:g.get(rem.v))
            {
                if(visited[neigh.v] ==0)
                {
                    q.add(new Pair(neigh.v, rem.v+1));
                }
            }

        }
        System.out.println(count);

    }

    public static class Pair
    {
        int v,  time;
        Pair(int v, int time)
        {
            this.v=v;
            this.time=time;
        }
    }


}
