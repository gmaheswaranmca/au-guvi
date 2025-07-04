import java.util.*;
public class FirstUniqueChar {
    private static int findFirst(String str) {
        Map<Character, Integer> dict = new HashMap<>();
        for(int I = 0; I < str.length(); I++) {
            int count = dict.computeIfAbsent(str.charAt(I), e -> 0)+1;
            dict.put(str.charAt(I), count);
        }
        for(int I = 0; I < str.length(); I++) {
            if(dict.get(str.charAt(I)) == 1) {
                return I;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(findFirst(str));
    }
}