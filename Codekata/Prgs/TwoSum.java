import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        List<Integer> arr = new ArrayList<>(n);
        for(String numStr : secondLine.trim().split(" ")) {
            arr.add(Integer.parseInt(numStr));
        }
        int target = scanner.nextInt();
        Map<Integer,Integer> pairs = new HashMap<Integer,Integer>(n);
        for(int I = 0; I < arr.size(); I++) {
            int diff = target - arr.get(I);
            if(pairs.containsKey(diff)) {
                System.out.println(pairs.get(diff) + " " + I);
                break;
            }
            pairs.put(arr.get(I), I);
        }
        scanner.close();
    }
}
