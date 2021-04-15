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

        HashMap<Integer, ArrayList<Edge>> transposedGraph = transpose(g,n);
        System.out.println(g);
        System.out.println(transposedGraph);

    }

    public static HashMap<Integer, ArrayList<Edge>> transpose(HashMap<Integer, ArrayList<Edge>> g , int n)
    {
        HashMap<Integer, ArrayList<Edge>> result = new HashMap<>();
        for(int i=0;i<n;i++)
            result.put(i, new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            for(Edge neigh : g.get(i))
            {
                result.get(neigh.v).add(new Edge(i,1));
            }
        }
        return result;
    }
}
