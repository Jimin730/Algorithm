import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 9655
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i=4; i<=N; i++){
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }

        if(dp[N] % 2 == 0){ //짝수면
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}