
import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 1003
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            fibo(n);

            sb.append(dp[n][0] + " " + dp[n][1] + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void fibo(int n){

        if(dp[n][0] != 0 || dp[n][1] != 0) return;

        fibo(n-1);
        fibo(n-2);

        dp[n][0] = dp[n-1][0] + dp[n-2][0];
        dp[n][1] = dp[n-1][1] + dp[n-2][1];
        
    }
}