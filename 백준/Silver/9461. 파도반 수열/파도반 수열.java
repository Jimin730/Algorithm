import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 9461
public class Main {

    static final int MAX_NUM = 101;
    static long[] dp = new long[MAX_NUM];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            padovan(n);

            sb.append(dp[n]).append("\n");

        }

        System.out.println(sb.toString());
    }

    public static long padovan(int n){
        if(n <= 0) return 0;
        else if(n <= 3) {
            dp[n] = 1;
            return dp[n];
        }
        else if(dp[n] != 0) return dp[n];

        dp[n] = padovan(n - 2) + padovan(n - 3);

        return dp[n];
    }
}