import java.util.Scanner;

public class PlagiarismDetector {
    static final int BASE = 256;
    static final int MOD = 1000000007;

    public static boolean rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m > n) return false;

        long patternHash = 0, textHash = 0, h = 1;

        // The value of h would be "pow(BASE, m-1)%MOD"
        for (int i = 0; i < m - 1; i++)
            h = (h * BASE) % MOD;

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (BASE * patternHash + pattern.charAt(i)) % MOD;
            textHash = (BASE * textHash + text.charAt(i)) % MOD;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern
            if (patternHash == textHash) {
                // Check for characters one by one
                if (text.substring(i, i + m).equals(pattern))
                    return true;
            }
            // Calculate hash value for next window of text
            if (i < n - m) {
                textHash = (BASE * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % MOD;
                // We might get negative value of textHash, converting it to positive
                if (textHash < 0)
                    textHash += MOD;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S1 = sc.nextLine();
        String S2 = sc.nextLine();

        if (rabinKarp(S1, S2) || rabinKarp(S2, S1)) {
            System.out.println("Plagiarism Detected");
        } else {
            System.out.println("No Plagiarism");
        }
    }
}