import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 15988
public class Main {

    static final int DIV = 1_000_000_009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) { //테스트 케이스 만큼 실행

            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n+1];

            dp[0] = 1;
            if(n >= 1) dp[1] = 1;
            if(n >= 2) dp[2] = 2; // 1+1, 2
            if(n >= 3) dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

            for (int i = 4; i <= n; i++) { //바텀업 방식

                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % DIV;
            }

            sb.append(dp[n]).append("\n"); //결과 기록
        }

        System.out.println(sb);
    }

}