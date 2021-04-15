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

        int [] visited = new int[n];
        Arrays.fill(visited, -1);
        boolean result = false;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==-1)
            {
                boolean isBipartite = checkBipartite(i,g,visited);
                if(isBipartite == false)
                {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static class Pair
    {
        int v;
        String psf;
        int level;
        Pair(int v, String psf, int level)
        {
            this.v=v;
            this.psf=psf;
            this.level = level;
        }
    }

    public static boolean checkBipartite(int src, HashMap<Integer, ArrayList<Edge>> g, int [] visited)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, src+" ", 0));
        while(q.size()>0)
        {
            Pair rem = q.poll();

            if(visited[rem.v]!=-1)
            {
                if(rem.level != visited[rem.v])
                    return false;
            }
            else
            {
                visited[rem.v] = rem.level;
            }

            for(Edge neigh : g.get(rem.v))
            {
                if(visited[neigh.v]==-1)
                {
                    q.add(new Pair(neigh.v, rem.psf+neigh.v, rem.level+1));
                }
            }
        }
        return true;
    }

}
