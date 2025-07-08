import java.util.*;
public class SubsetSum {
    public static void main(String [] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        int count = 0;
        //logic 
        int maskCount = 1 << n;
        for(int mask = 0; mask < maskCount; mask++) {
            int sum = 0;
            for(int bit = 0; bit < n; bit++) {
                if((mask & (1 << bit)) != 0) {
                    sum += arr.get(bit);
                }
            }
            if(sum == k) {
                count ++;
            }
        }
        System.out.print(count);

    }
}
