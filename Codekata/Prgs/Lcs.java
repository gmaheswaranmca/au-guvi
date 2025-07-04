import java.util.*;
public class Lcs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        List<Integer> arr = new ArrayList<>(n);
        for(String numStr : secondLine.trim().split(" ")) {
            arr.add(Integer.parseInt(numStr));
        }
        System.out.print(findLength(arr));
    }    
    private static int findLength(List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr.size());
        for(int num : arr) {
            set.add(num);
        }
        //
        int max = 0;
        for(int num : arr) {
            if(set.contains(num-1)) {//num is not starting seq
                continue;
            }
            int seed = num;//sequence started                   
            int length = 1;
            while(set.contains(seed+1)) {               
                seed++;//travel in sequence
                length++;
            }            
            if(length > max) { max = length; }//check length with max
        }
        return max;
    }
}
