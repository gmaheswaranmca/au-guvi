import java.util.*;
class MinHeap {
    private List<Integer> arr;
    public MinHeap() {
        arr = new ArrayList<>();
    }
    public void offer(int val) {
        arr.add(val);
        heapifyUp(arr.size() - 1);
    }
    public int peek() {
        return arr.get(0);
    }
    public int poll() {
        int result =  peek();
        swap(0, arr.size()-1);
        arr.removeLast();
        heapifyDown(0);
        return result;
    }
    public void buildHeap(List<Integer> newArr) {
        arr = newArr;
        for(int I = arr.size() / 2 - 1; I >= 0; I--) {
            heapifyDown(I);
        }
    }
    private void swap(int I, int J) {
        int temp = arr.get(I);
        arr.set(I,arr.get(J));
        arr.set(J,temp);
    }
    public void heapifyDown(int nodeIndex) {
        int minIndex = nodeIndex;
        int leftIndex = 2 * nodeIndex + 1;
        int rightIndex = 2 * nodeIndex + 2;
        if(leftIndex < arr.size() && arr.get(leftIndex) < arr.get(nodeIndex)) {
            minIndex = leftIndex;
        }
        if(rightIndex < arr.size() && arr.get(rightIndex) < arr.get(nodeIndex)) {
            minIndex = rightIndex;
        }
        if(minIndex != nodeIndex) {
            swap(minIndex, nodeIndex);
            heapifyDown(minIndex);
        }
    }
    public void heapifyUp(int nodeIndex) {
        int parentIndex = (nodeIndex - 1) / 2;
        if(arr.get(nodeIndex) < arr.get(parentIndex)) {
            swap(parentIndex, nodeIndex);
            heapifyUp(parentIndex);
        }
    }
}

public class MinHeapMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MinHeap heap = new MinHeap();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("insert")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                heap.offer(val);
            } else if (line.startsWith("extractMin")) {
                try {
                    System.out.println(heap.poll());
                } catch (NoSuchElementException e) {
                    // Optionally handle empty heap
                }
            } else if (line.startsWith("heapify")) {
                String[] parts = line.split(" ");
                int k = Integer.parseInt(parts[1]);
                List<Integer> arr = new ArrayList<>(k);
                for (int j = 0; j < k; j++) {
                    arr.set(j, Integer.parseInt(parts[2 + j]));
                }
                heap.buildHeap(arr);
            }
        }
    }
}