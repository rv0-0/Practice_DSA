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
        int [] result = kahns(n,g);
        for(int x: result)
            System.out.println(x);
    }

    public static int[] kahns(int n , HashMap<Integer, ArrayList<Edge>> g)
    {
        int []indegree = new int[n];
        int []ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int indx =0;

        for(int i=0;i<n;i++) {
            for (Edge neigh : g.get(i)) {
                indegree[neigh.v]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        while(q.size()>0)
        {
            int rem = q.poll();
            ans[indx++] = rem;
            for(Edge neigh : g.get(rem))
            {
                indegree[neigh.v]--;

                if(indegree[neigh.v] == 0)
                    q.add(neigh.v);
            }
        }
        if(indx == n)
            return ans;
        else
        {
            int [] k ={-1};
            return k;
        }
    }
}
