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
        
        boolean[] visited = new boolean[n];
        boolean result = false;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
                result = isCyclic(i,g,visited);
            if(result)
                break;
        }
    }
    
    public static class Pair
    {
        int v;
        String psf;
        Pair(int v, String psf)
        {
            this.v=v;
            this.psf=psf;
        }
    }
    
    public static boolean isCyclic(int src,HashMap<Integer, ArrayList<Edge>> g, boolean []visited)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, src+" "));
        
        while(q.size()>0)
        {
            Pair rem = q.poll();
            
            if(visited[rem.v] == true)
                return true;
            visited[rem.v] = true;
            
            for(Edge neigh : g.get(rem.v))
            {
                if(!visited[neigh.v])
                {
                    q.add(new Pair(neigh.v, rem.psf+neigh.v));
                }
            }
        }
        return false;
    }
}
