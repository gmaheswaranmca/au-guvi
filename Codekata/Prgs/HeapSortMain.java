import java.util.*;
class HeapSorting {
    private void swap(List<Integer> arr, int I, int J) {
        int temp = arr.get(I);
        arr.set(I, arr.get(J));
        arr.set(J, temp);
    }
    private void heapify(List<Integer> arr, int N, int nodeIndex) {
        int maxIndex = nodeIndex;
        int leftIndex = nodeIndex * 2 + 1;
        int rightIndex = nodeIndex * 2 + 2;
        if(leftIndex < N && arr.get(leftIndex) > arr.get(maxIndex)) {
            maxIndex = leftIndex;
        }
        if(rightIndex < N && arr.get(rightIndex) > arr.get(maxIndex)) {
            maxIndex = rightIndex;
        }
        if(maxIndex != nodeIndex) {
            swap(arr, nodeIndex, maxIndex);
            heapify(arr, N, maxIndex);
        }
    }
    private void buildHeap(List<Integer> arr) {
        for(int I = arr.size() / 2 - 1; I >= 0; I--) {
            heapify(arr, arr.size(), I);
        }
    }
    public void sort(List<Integer> arr) {
        buildHeap(arr);
        swap(arr, 0, arr.size()-1);//
        int N = arr.size() - 1;
        while(N > 1) {
            heapify(arr,N, 0);
            swap(arr, 0, N-1);
            N--;
        }
    }
}
public class HeapSortMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        for(String numStr : secondLine.trim().split(" ")) {
            arr.add(Integer.parseInt(numStr));
        } 
        HeapSorting sorting = new HeapSorting();
        sorting.sort(arr);
        for(int num : arr) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}