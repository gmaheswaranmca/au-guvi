public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int uI = 1; uI < n; uI++) {//1..n-1,2..n-1,3..n-1,...,n-1..n-1//unsorted part
            int key = arr[uI];//take out first element of unsorted part
            int keyIndex = uI;
            
            for(int sI = uI - 1; sI >= 0 ; sI--) {//0..0,1..0,2..0,...,n-1..0//sorted part
               if(arr[sI] > key) {
                    arr[sI + 1] = arr[sI];//shift right
                    keyIndex --;//find new key index
                    continue;
               }

               break;
            }  
            if(uI != keyIndex)
                arr[keyIndex] = key;//insert
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}