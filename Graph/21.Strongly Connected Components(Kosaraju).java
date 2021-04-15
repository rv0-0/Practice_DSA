import java.util.*;

public class Main {
     public static class Edge {
        int v, wt;

        Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        public String toString()
        {
            return v+"";
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
        boolean [] visited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                fillStack(g,visited,i,st);
            }
        }
        HashMap<Integer, ArrayList<Edge>> transposedGraph = transpose(g,n);

        int countOfStronglyConnectedComponent = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                countOfStronglyConnectedComponent++;
                dfs(transposedGraph,visited,i);
            }
        }
        System.out.println(countOfStronglyConnectedComponent);

    }

    public static void fillStack(HashMap<Integer, ArrayList<Edge>> g, boolean [] visited, int src,Stack<Integer> st)
    {
        visited[src] = true;

        for(Edge neigh : g.get(src))
        {
            if(!visited[neigh.v])
            {
                fillStack(g,visited, neigh.v,st);
            }
        }
        st.add(src);
    }

    public static HashMap<Integer, ArrayList<Edge>> transpose(HashMap<Integer, ArrayList<Edge>> g, int n)
    {
        HashMap<Integer, ArrayList<Edge>> result = new HashMap<>();

        for(int i=0;i<n;i++)
            result.put(i,new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            for(Edge neigh : g.get(i))
            {
                result.get(neigh.v).add(new Edge(i,1));
            }
        }
        return result;
    }

    public static void dfs(HashMap<Integer, ArrayList<Edge>> g, boolean [] visited, int src)
    {
        visited[src]=true;
        for(Edge neigh: g.get(src))
        {
            if(!visited[neigh.v])
            {
                dfs(g,visited, neigh.v);
            }
        }
    }

}
