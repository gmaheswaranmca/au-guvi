import java.util.*;

public class CourseScheduleOrdering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of courses
        int m = sc.nextInt(); // number of prerequisite pairs

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            order.add(curr);
            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }

        if (order.size() == n) {
            System.out.println(order);
        } else {
            System.out.println(new ArrayList<Integer>());
        }
    }
}