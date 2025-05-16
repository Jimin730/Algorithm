import java.io.*;

// 백준 11727
public class Main {

    protected static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];

        System.out.println(dp(n));

    }

    protected static int dp(int n){

        if(n <= 1) return 1;
        if(memo[n] != 0) return memo[n];

        memo[n] = (Math.max(Math.max(dp(n - 1) + dp(n - 2), dp(n - 2) + dp(n - 2)), dp(n - 1) + dp(n - 2) + dp(n - 2))) % 10007;
        return memo[n];
    }
}