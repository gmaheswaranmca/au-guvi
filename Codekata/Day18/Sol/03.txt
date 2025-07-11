import java.util.*;

public class DistinctSubstringsZAlgo {
    // Function to build Z-array for a given string
    private static int[] buildZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    // Function to count distinct substrings using Z Algorithm
    public static int countDistinctSubstrings(String s) {
        int n = s.length();
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String suffix = s.substring(i);
            int[] z = buildZ(suffix);
            for (int len = 1; len <= suffix.length(); len++) {
                substrings.add(suffix.substring(0, len));
            }
        }
        return substrings.size();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {
            String s = sc.nextLine().trim();
            System.out.println(countDistinctSubstrings(s));
        }
    }
}