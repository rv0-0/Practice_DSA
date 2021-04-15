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
            int wt = sc.nextInt();
            g.get(u).add(new Edge(v, wt));
            g.get(v).add(new Edge(u, wt));
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] visited = new boolean[n];
        int criteria = sc.nextInt();


        printMinLenPath(g, visited, src, dest, src + "", 0, criteria);

        System.out.println(floorPath + "@" + floorPathLen);
    }

    public static void printMinLenPath(HashMap<Integer, ArrayList<Edge>> g, boolean[] visited, int src, int dest, String psf, int wsf, int criteria) {
        if (src == dest) {
            if (wsf<criteria && wsf>floorPathLen)
            {
                floorPathLen = wsf;
                floorPath = psf;
            }
        }

        visited[src] = true;

        for (Edge neigh : g.get(src)) {
            if (!visited[neigh.v]) {
                printMinLenPath(g, visited, neigh.v, dest, psf + neigh.v, wsf + neigh.wt, criteria);
            }
        }

        visited[src] = false;
    }
}
