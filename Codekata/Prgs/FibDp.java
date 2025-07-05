import java.util.*;
public class FibDp {
    private static int fibb(int n) {
        int[] table = new int[n+1];
        table[0] = 1;
        table[1] = 1;
        for(int I = 2; I < n; I++) {
            table[I] = table[I-1] + table[I-2];
        }
        return table[n-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(fibb(n));
        scanner.close();
    }
}