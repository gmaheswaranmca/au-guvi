import java.util.*;
public class KthLargest {
    private static int findMax(List<Integer> arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);//min heap
        for(int I =0 ; I < k; I++) {
            heap.offer(arr.get(I));
        }
        for(int I = k; I < arr.size(); I++) {
            if(arr.get(I) > heap.peek()) {
                heap.poll(); 
                heap.offer(arr.get(I));
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        List<Integer> arr = new ArrayList<>(n);
        for(String e : secondLine.trim().split(" ")) {
            arr.add(Integer.parseInt(e));
        }
        System.out.print(findMax(arr, k));
        scanner.close();
    }
}
