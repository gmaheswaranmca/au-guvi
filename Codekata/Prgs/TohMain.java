import java.util.Scanner; 
public class TohMain {
    public static void toh(int n, char source, char destination, char aux) { 
        if(n == 1) {
            System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
            return;
        }
        toh(n-1,source, aux, destination);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        toh(n-1,aux,destination,source);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        toh(n,'A','C','B');
    }
}