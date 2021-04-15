import java.util.*;

public class Main {
    public static int floorPathLen = Integer.MAX_VALUE;
    static String floorPath = "";

    public static class Edge {
        int v, wt;

        Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
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
            //int wt = sc.nextInt();
            g.get(u).add(new Edge(v, 1));
            g.get(v).add(new Edge(u, 1));
        }
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> component =  new ArrayList<>();
                getConnectedVertices(g,visited,i, component);
                result.add(component);
            }
        }
        System.out.println(result);
    }

    public static void getConnectedVertices(HashMap<Integer, ArrayList<Edge>> g, boolean[] visited, int src,ArrayList<Integer> component)
    {
        visited[src] = true;
        component.add(src);

        for(Edge neigh : g.get(src))
        {
            if(!visited[neigh.v])
            {
                getConnectedVertices(g, visited, neigh.v,component);
            }
        }
    }
}
