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
        printAllPath(g,visited, src,dst,src+"");
    }

    public static void printAllPath(HashMap<Integer, ArrayList<Edge>> g,boolean []  visited, int src, int dst, String psf)
    {
        if(src == dst)
        {
            System.out.println(psf);
            return;
        }
        visited[src] = true;

        for(Edge neigh:g.get(src))
        {
            if(!visited[neigh.v])
            {
                printAllPath(g,visited, neigh.v,dst,psf+neigh.v);
            }
        }
        visited[src] = false;
    }

}
