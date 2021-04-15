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
    public static void main(String [] args) {
        HashMap<Integer, ArrayList<Edge>> g = new HashMap<>();
        int n, e;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<Edge>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(new Edge(v, 1));
            g.get(v).add(new Edge(u, 1));
        }

        int src = sc.nextInt();
        int dst = sc.nextInt();
        boolean [] visited = new boolean[n];
        System.out.println(dfs(g,visited, src,dst));
    }

    public static boolean dfs(HashMap<Integer, ArrayList<Edge>> g, boolean [] visited, int src, int dst )
    {
        if(src == dst)
            return true;

        visited[src] = true;

        for(Edge neigh : g.get(src))
        {
            if(!visited[neigh.v])
            {
                if(dfs(g,visited, neigh.v, dst))
                    return true;
            }
        }
        return false;
    }

}
