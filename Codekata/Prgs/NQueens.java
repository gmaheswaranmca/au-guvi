import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> solutions = solveNQueens(n);
        if (solutions.isEmpty()) {
            System.out.println("No solution");
        } else {
            for (List<String> sol : solutions) {
                for (String row : sol) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(res, board, 0, n, new boolean[n], 
            new boolean[2 * n], new boolean[2 * n]);
        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] board, int row, 
        int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            res.add(sol);
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n, id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            board[row][col] = 'Q';
            cols[col] = d1[id1] = d2[id2] = true;
            backtrack(res, board, row + 1, n, cols, d1, d2);
            board[row][col] = '.';
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }
}

