import java.util.*;

public class PrimMainPQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = sc.nextInt();

        boolean[] visited = new boolean[N];
        List<List<Integer>> edges = new ArrayList<>();//edge=(u,v,w)
        List<List<Integer>> result = new ArrayList<>();//to store the result edges
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (graph[i][j] != 0)
                    edges.add(Arrays.asList(i, j, graph[i][j]));
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.get(2)));//min-heap
        int u = 0;
        int count = 1;
        visited[u] = true;
        //add u->v edges to pq
        for (List<Integer> edge : edges) {
            if (edge.get(0) == u && !visited[edge.get(1)]) {
                pq.offer(edge);
            }
        }

        while (!pq.isEmpty()) {
            List<Integer> edge = pq.poll();//minimal edge 
            u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if (visited[v]) continue; // skip if v is already visited
            visited[v] = true;
            result.add(Arrays.asList(u + 1, v + 1, w)); // store the edge in result (1-based index)
            // add new edges from v to pq
            for (List<Integer> nextEdge : edges) {
                if (nextEdge.get(0) == v && !visited[nextEdge.get(1)]) {
                    pq.offer(nextEdge);
                }
            }
            count++;
            if (count == N) break; // all vertices are included in the MST
        }
        //print the result edges
        for (List<Integer> resEdge : result) {
            System.out.println(resEdge.get(0) + " " + resEdge.get(1) + " " + resEdge.get(2));
        }

    }
}