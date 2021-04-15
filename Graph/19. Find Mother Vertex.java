/*
* A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G can be reached by a path from v.
*/
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
            //g.get(v).add(new Edge(u, 1));
        }
        Stack<Integer> st = new Stack<>();
        boolean []visited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
                fillStack(g,visited,st,i);
        }

        int potentialMotherVertex = st.pop();
        visited = new boolean[n];
        checkConnectivity(g,visited,potentialMotherVertex);

        if(count == n)
            System.out.println(potentialMotherVertex);
        else
            System.out.println(-1);

    }

    public static void fillStack(HashMap<Integer, ArrayList<Edge>> g, boolean []visited,Stack<Integer> st, int src )
    {
        visited[src] = true;
        for(Edge neigh:g.get(src))
        {
            if(!visited[neigh.v])
            {
                fillStack(g,visited,st, neigh.v);
            }
        }
        st.push(src);
    }
    static int count = 0;

    public static void checkConnectivity(HashMap<Integer, ArrayList<Edge>> g, boolean []visited, int src)
    {
        visited[src] = true;
        count++;
        for(Edge neigh: g.get(src))
        {
            if(!visited[neigh.v])
            {
                checkConnectivity(g,visited, neigh.v);
            }
        }
    }

}
