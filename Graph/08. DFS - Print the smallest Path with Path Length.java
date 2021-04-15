import java.util.*;

public class Main {
    public static int minPathLen = Integer.MAX_VALUE;
    static String minPath = "";

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
            int wt = sc.nextInt();
            g.get(u).add(new Edge(v, wt));
            g.get(v).add(new Edge(u, wt));
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] visited = new boolean[n];


        printMinLenPath(g, visited, src, dest, src + "", 0);

        System.out.println(minPath + "@" + minPathLen);
    }

    public static void printMinLenPath(HashMap<Integer, ArrayList<Edge>> g, boolean[] visited, int src, int dest, String psf, int wsf) {
        if (src == dest) {
            if (minPathLen > wsf) {
                minPathLen = wsf;
                minPath = psf;
            }
        }

        visited[src] = true;

        for (Edge neigh : g.get(src)) {
            if (!visited[neigh.v]) {
                printMinLenPath(g, visited, neigh.v, dest, psf + neigh.v, wsf + neigh.wt);
            }
        }

        visited[src] = false;
    }
}
