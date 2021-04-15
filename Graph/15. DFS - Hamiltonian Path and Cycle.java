
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

        int src = sc.nextInt();
        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(g,visited, src, src+"", src);

    }

    public static void hamiltonian(HashMap<Integer, ArrayList<Edge>> g, HashSet<Integer> visited, int src, String psf, int osrc)
    {
        if(visited.size() == g.size()-1)
        {
            System.out.print(psf);
            boolean closedLoop = false;
            for(Edge neigh:g.get(src))
            {
                if(neigh.v == osrc)
                    closedLoop = true;
            }
            if(closedLoop)
                System.out.println(osrc+"->Cycle");
            else
                System.out.println("->Path");
        }

        visited.add(src);
        for(Edge neigh:g.get(src))
        {
            if(visited.contains(neigh.v) == false)
            {
                hamiltonian(g,visited, neigh.v, psf+neigh.v, osrc);
            }
        }
        visited.remove(src);
    }

}
