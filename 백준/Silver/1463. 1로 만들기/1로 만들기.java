import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1463번
public class Main {

    static int[] dp; //메모이제이션

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        System.out.println(recursionDp(n));

    }

    static public int recursionDp(int n){

        if(n <= 1) return 0;
        if(dp[n] != 0) return dp[n];

        if (n % 6 == 0) {
            dp[n] = Math.min(Math.min(recursionDp(n / 3), recursionDp(n / 2)), recursionDp(n - 1)) + 1;
        } else if(n%3 == 0){
            dp[n] = Math.min(recursionDp(n / 3), recursionDp(n - 1)) + 1;
        } else if (n % 2 == 0) {
            dp[n] = Math.min(recursionDp(n / 2), recursionDp(n - 1)) + 1;
        } else {
            dp[n] = recursionDp(n - 1) + 1;
        }
        return dp[n];
    }
}