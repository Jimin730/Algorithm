import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            System.out.println(1);
            return;
        }

        long prev2 = 1; // f(n-2)
        long prev1 = 1; // f(n-1)
        long current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(current);
    }
}