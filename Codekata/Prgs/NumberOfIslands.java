import java.util.*;

public class NumberOfIslands {
    static int m, n;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        grid = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }
        System.out.println(numIslands());
    }
    static int numIslands() {
        int count = 0;
        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n ||
          grid[i][j] != '1' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i-1,j);//up
        dfs(i+1,j);//down
        dfs(i,j-1);//left
        dfs(i,j+1);//right
    }
}