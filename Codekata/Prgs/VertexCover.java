import java.util.*;
public class VertexCover {
    static List<Integer>[] tree;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        dp = new int[n + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(dfs(1, 1, -1));
    }

    // state: u = current node, take = 0/1 (not taken/taken), par = parent
    static int dfs(int u, int take, int par) {
        if (dp[u][take] != -1) return dp[u][take];
        int res = 0;
        if (take == 1) {
            res = 1;
            for (int v : tree[u]) {
                if (v != par) {
                    res += Math.min(dfs(v, 0, u), dfs(v, 1, u));
                }
            }
        } else {
            for (int v : tree[u]) {
                if (v != par) {
                    res += dfs(v, 1, u);
                }
            }
        }
        return dp[u][take] = res;
    }
}
