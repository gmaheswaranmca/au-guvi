import java.util.*;
public class GreedyCoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> coins = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }
        int amount = sc.nextInt();
        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    public static int coinChange(List<Integer> coins, int target) {
        Collections.sort(coins, Collections.reverseOrder());
        int count = 0;
        for(int coin : coins) {
            while(target - coin >= 0) {
                count++;
                target -= coin;
            }
        }
        return count;
    }
}

