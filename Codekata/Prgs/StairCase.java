import java.util.Scanner;

public class StairCase {
    private static int findCount(int n) {
        int[] table = new int[n+1+1]; // 1-based index + n==1
        table[1] = 1;
        table[2] = 2;
        for(int I = 3; I <= n; I++) {
            table[I] = table[I-1] + table[I-2];
        }
        return table[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(findCount(n));
        scanner.close();
    }
}
